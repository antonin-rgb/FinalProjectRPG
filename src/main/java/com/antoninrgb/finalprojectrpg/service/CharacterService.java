package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.*;
import com.antoninrgb.finalprojectrpg.model.Character;
import com.antoninrgb.finalprojectrpg.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class CharacterService {

    private final CharacterRepo characterRepo;
    private final InventoryRepo inventoryRepo;
    private final PathRepo pathRepo;
    private final VirtueRepo virtueRepo;
    private final DominionRepo dominionRepo;
    private final EnemyRepo enemyRepo;

    public CharacterService(CharacterRepo characterRepo, InventoryRepo inventoryRepo, PathRepo pathRepo, VirtueRepo virtueRepo, DominionRepo dominionRepo, EnemyRepo enemyRepo) {
        this.characterRepo = characterRepo;
        this.inventoryRepo = inventoryRepo;
        this.pathRepo = pathRepo;
        this.virtueRepo = virtueRepo;
        this.dominionRepo = dominionRepo;
        this.enemyRepo = enemyRepo;
    }

    public List<Character> findAllPlayers() {
        return characterRepo.findAll();
    }

    /* Upon creating a new player, an inventory is automatically created with a set amount of gold and assigned to the same player. */
    public Character save(Character character) {
        Inventory inventory = new Inventory();
        inventory.setGold(500.0);
        character.setInventory(inventory);
        return characterRepo.save(character);
    }

    public Character assignPath(int playerId, int pathId) {
        Character character = characterRepo.findById(playerId);
        Path path = pathRepo.findById(pathId);
        if (character.getPath() != null) {
            throw new IllegalStateException("Player already has a Path assigned.");
        } else {
            character.setPath(path);
            character.setHp(character.getHp() + path.getHp_bonus());
            character.setAttack(character.getAttack() + path.getAttack_bonus());
            character.setMagic(character.getMagic() + path.getMagic_bonus());
            return characterRepo.save(character);
        }
    }

    public Character assignVirtue(int playerId, int virtueId) {
        Character character = characterRepo.findById(playerId);
        Virtue virtue = virtueRepo.findById(virtueId);
        if (character.getVirtue() != null) {
            throw new IllegalStateException("Player already has a Virtue assigned.");
        } else {
            character.setVirtue(virtue);
            return characterRepo.save(character);
        }
    }

    public Character assignDominion(int playerId, int dominionId) {
        Character character = characterRepo.findById(playerId);
        Dominion dominion = dominionRepo.findById(dominionId);
        if (character.getDominion() != null) {
            throw new IllegalStateException("You already chose a dominion.");
        } else {
            character.setDominion(dominion);
            List<Enemy> enemiesDominion = enemyRepo.findByDominionId(dominionId);
            Enemy enemySelected = enemiesDominion.get(new Random().nextInt(enemiesDominion.size()));
            Battle battle = new Battle();
            battle.setEnemy(enemySelected);
            battle.setPlayer(character);
            return characterRepo.save(character);
        }
    }
}
