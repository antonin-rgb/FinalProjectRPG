package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.*;
import com.antoninrgb.finalprojectrpg.model.Avatar;
import com.antoninrgb.finalprojectrpg.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class AvatarService {

    private final AvatarRepository avatarRepository;
    private final PathRepository pathRepository;
    private final VirtueRepository virtueRepository;
    private final DominionRepository dominionRepository;
    private final EnemyRepository enemyRepository;

    public AvatarService(AvatarRepository avatarRepository, PathRepository pathRepository, VirtueRepository virtueRepository, DominionRepository dominionRepository, EnemyRepository enemyRepository) {
        this.avatarRepository = avatarRepository;
        this.pathRepository = pathRepository;
        this.virtueRepository = virtueRepository;
        this.dominionRepository = dominionRepository;
        this.enemyRepository = enemyRepository;
    }

    public List<Avatar> findAllAvatars() {
        return avatarRepository.findAll();
    }

    /* Upon creating a new player, an inventory is automatically created with a set amount of gold and assigned to the same player. */
    public Avatar save(Avatar avatar) {
        Inventory inventory = new Inventory();
        inventory.setGold(500.0);
        avatar.setInventory(inventory);
        return avatarRepository.save(avatar);
    }

    public Avatar assignPath(int avatarId, int pathId) {
        Avatar avatar = avatarRepository.findById(avatarId);
        Path path = pathRepository.findById(pathId);
        if (avatar.getPath() != null) {
            throw new IllegalStateException("Character already has a Path assigned.");
        } else {
            avatar.setPath(path);
            avatar.setHp(avatar.getHp() + path.getHp_bonus());
            avatar.setAttack(avatar.getAttack() + path.getAttack_bonus());
            avatar.setMagic(avatar.getMagic() + path.getMagic_bonus());
            return avatarRepository.save(avatar);
        }
    }

    public Avatar assignVirtue(int avatarId, int virtueId) {
        Avatar avatar = avatarRepository.findById(avatarId);
        Virtue virtue = virtueRepository.findById(virtueId);
        if (avatar.getVirtue() != null) {
            throw new IllegalStateException("Character already has a Virtue assigned.");
        } else {
            avatar.setVirtue(virtue);
            return avatarRepository.save(avatar);
        }
    }

    public Avatar assignDominion(int avatarId, int dominionId) {
        Avatar avatar = avatarRepository.findById(avatarId);
        Dominion dominion = dominionRepository.findById(dominionId);
        if (avatar.getDominion() != null) {
            throw new IllegalStateException("You already chose a dominion.");
        } else {
            avatar.setDominion(dominion);
            List<Enemy> enemiesDominion = enemyRepository.findByDominionId(dominionId);
            Enemy enemySelected = enemiesDominion.get(new Random().nextInt(enemiesDominion.size()));
            Battle battle = new Battle();
            battle.setEnemy(enemySelected);
            battle.setPlayer(avatar);
            return avatarRepository.save(avatar);
        }
    }

    public Avatar findByNickname(String nickname) {
        return avatarRepository.findByNickname(nickname);
    }
}
