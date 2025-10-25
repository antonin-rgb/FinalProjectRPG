package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.*;
import com.antoninrgb.finalprojectrpg.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class PlayerService {

    private final PlayerRepo playerRepo;
    private final InventoryRepo inventoryRepo;
    private final PathRepo pathRepo;
    private final VirtueRepo virtueRepo;
    private final DominionRepo dominionRepo;
    private final EnemyRepo enemyRepo;

    public PlayerService(PlayerRepo playerRepo, InventoryRepo inventoryRepo, PathRepo pathRepo, VirtueRepo virtueRepo, DominionRepo dominionRepo, EnemyRepo enemyRepo) {
        this.playerRepo = playerRepo;
        this.inventoryRepo = inventoryRepo;
        this.pathRepo = pathRepo;
        this.virtueRepo = virtueRepo;
        this.dominionRepo = dominionRepo;
        this.enemyRepo = enemyRepo;
    }

    public List<Player> findAllPlayers() {
        return playerRepo.findAll();
    }

    /* Upon creating a new player, an inventory is automatically created with a set amount of gold and assigned to the same player. */
    public Player save(Player player) {
        Inventory inventory = new Inventory();
        inventory.setGold(500.0);
        player.setInventory(inventory);
        return playerRepo.save(player);
    }

    public Player assignPath(int playerId, int pathId) {
        Player player = playerRepo.findById(playerId);
        Path path = pathRepo.findById(pathId);
        if (player.getPath() != null) {
            throw new IllegalStateException("Player already has a Path assigned.");
        } else {
            player.setPath(path);
            player.setHp(player.getHp() + path.getHp_bonus());
            player.setAttack(player.getAttack() + path.getAttack_bonus());
            player.setMagic(player.getMagic() + path.getMagic_bonus());
            return playerRepo.save(player);
        }
    }

    public Player assignVirtue(int playerId, int virtueId) {
        Player player = playerRepo.findById(playerId);
        Virtue virtue = virtueRepo.findById(virtueId);
        if (player.getVirtue() != null) {
            throw new IllegalStateException("Player already has a Virtue assigned.");
        } else {
            player.setVirtue(virtue);
            return playerRepo.save(player);
        }
    }

    public Player assignDominion(int playerId, int dominionId) {
        Player player = playerRepo.findById(playerId);
        Dominion dominion = dominionRepo.findById(dominionId);
        if (player.getDominion() != null) {
            throw new IllegalStateException("You already chose a dominion.");
        } else {
            player.setDominion(dominion);
            List<Enemy> enemiesDominion = enemyRepo.findByDominionId(dominionId);
            Enemy enemySelected = enemiesDominion.get(new Random().nextInt(enemiesDominion.size()));
            Battle battle = new Battle();
            battle.setEnemy(enemySelected);
            battle.setPlayer(player);
            return playerRepo.save(player);
        }
    }
}
