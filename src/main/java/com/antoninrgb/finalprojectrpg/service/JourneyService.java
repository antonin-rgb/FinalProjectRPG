package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.enums.SpecialtyType;
import com.antoninrgb.finalprojectrpg.model.*;
import com.antoninrgb.finalprojectrpg.repository.JourneyRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import static com.antoninrgb.finalprojectrpg.enums.SpecialtyType.*;

@Service
public class JourneyService {

    private final JourneyRepository journeyRepository;
    private final AvatarService avatarService;
    private final UserService userService;
    private final DominionService dominionService;
    private final EnemyService enemyService;

    public JourneyService(JourneyRepository journeyRepository, AvatarService avatarService, UserService userService, DominionService dominionService, EnemyService enemyService) {
        this.journeyRepository = journeyRepository;
        this.avatarService = avatarService;
        this.userService = userService;
        this.dominionService = dominionService;
        this.enemyService = enemyService;
    }

    public List<Journey> findAllBattles() {
        return journeyRepository.findAll();
    }

    public String save(Journey journey) {
        journeyRepository.save(journey);
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        int id = user.getActiveAvatarId();
        Avatar avatar = avatarService.findById(id);
        journey.setAvatar(avatar);
        avatar.setActiveJourney(journey.getId());
        journeyRepository.save(journey);
        return "The world is alive with wonder… and danger! From the sunlit fields of the Sunny Prairie, where whispers speak of an ancient beast, to the shadowed depths of the Urtica Jungle, where predators both natural and unnatural stalk their prey. Beyond the molten fury of the Deathbound Volcano, secrets long buried stir, and in the shattered halls of the Astronomer’s Lab, the cosmos itself waits to reveal its mysteries. Armed with courage — and weapons forged for heroes — you step into a land where every step could awaken legend… or doom.";
    }

    public Journey chooseDominion(int dominionId) {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        int id = user.getActiveAvatarId();
        Avatar avatar = avatarService.findById(id);
        Dominion dominion = dominionService.findById(dominionId);
        Journey journey = journeyRepository.findById(avatar.getActiveJourney());
        List<Enemy> enemiesDominion = enemyService.findByDominionId(dominionId);
        Enemy enemySelected = enemiesDominion.get(new Random().nextInt(enemiesDominion.size()));
        journey.setEnemy(enemySelected);
        journey.setDominion(dominion);
        System.out.println("You'll fight " + enemySelected);
        avatar.setActiveJourney(journey.getId());
        return journeyRepository.save(journey);
    }

    public String toBattle() {
        // Get active avatar and journey, extract avatar and enemy HP.
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        int id = user.getActiveAvatarId();
        Avatar avatar = avatarService.findById(id);
        Journey journey = journeyRepository.findById(avatar.getActiveJourney());
        double avatarCurrentHp = avatar.getHp();
        double enemyCurrentHp = journey.getEnemy().getHp();

        StringBuilder battleLog = new StringBuilder();
        battleLog.append("Battle started!\n")
                .append(avatar.getNickname())
                .append(" vs ")
                .append(journey.getEnemy().getName())
                .append("\n\n");

        // Implement Specialty from the virtue
        Specialty s = avatar.getVirtue().getSpecialty();
        if (s != null) {
            switch (s.getType()) {
                case HP_BUFF:
                    avatar.setHp(avatar.getHp() + s.getValue());
                    break;
                case ATK_BUFF:
                    avatar.setAttack(avatar.getAttack() + s.getValue());
                    break;
                case MAGIC_BUFF:
                    avatar.setMagic(avatar.getMagic() + s.getValue());
                    break;
            }
        }

        // Rounds of the battle, if Avatar has STEALTH_ATK specialty, there is a chance the enemy is instantly killed in each round.
        while (avatarCurrentHp > 0 && enemyCurrentHp > 0) {

            // Avatar attack
            if (avatar.getVirtue().getSpecialty().getType() == SpecialtyType.STEALTH_ATK) {
                double chance = avatar.getVirtue().getSpecialty().getValue();
                if (new Random().nextDouble() < chance) {
                    battleLog.append("Stealth attack triggered! Enemy instantly defeated!\n");
                    enemyCurrentHp = 0;
                    break;
                }
            }
            double avatarDamage = calculateAvatarDamage(avatar);
            enemyCurrentHp -= calculateAvatarDamage(avatar);
            battleLog.append(avatar.getNickname()).append(" hits ").append(journey.getEnemy().getName())
                    .append(" for ").append(String.format("%.2f", avatarDamage))
                    .append(" damage. Enemy HP: ").append(enemyCurrentHp).append("\n");

            // Enemy attack
            double enemyDamage = (journey.getEnemy().getDamage() + new Random().nextInt(51));
            avatarCurrentHp -= enemyDamage;
            battleLog.append(journey.getEnemy().getName()).append(" hits ").append(avatar.getNickname())
                    .append(" for ").append(String.format("%.2f", enemyDamage))
                    .append(" damage. Avatar HP: ").append(avatarCurrentHp).append("\n");
        }

        if (avatarCurrentHp <= 0) {
            battleLog.append("You lose!\n");
            return battleLog.toString();
        }
        battleLog.append("You win!\n");
        return battleLog.toString();
    }

    // Calculate the damage dealt by the avatar
    public double calculateAvatarDamage(Avatar avatar) {
        Weapon weapon = avatar.getWeapon();
        double baseAttack = avatar.getAttack() + weapon.getAttack();
        boolean isCritical = new Random().nextDouble() < weapon.getCrit();
        if (isCritical) {
            baseAttack *= 1.5;
            System.out.println("Critical hit!");
        }
        double magicBonus = avatar.getMagic() * weapon.getMagicPercent();
        double totalDamage = baseAttack + magicBonus;
        return totalDamage;
    }
}
