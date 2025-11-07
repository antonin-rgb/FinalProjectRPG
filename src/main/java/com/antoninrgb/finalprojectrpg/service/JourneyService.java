package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.*;
import com.antoninrgb.finalprojectrpg.repository.JourneyRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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

    public Journey save(Journey journey) {
        journeyRepository.save(journey);
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        int id = user.getActiveAvatarId();
        Avatar avatar = avatarService.findById(id);
        journey.setAvatar(avatar);
        avatar.setActiveJourney(journey.getId());
        System.out.println("Time to get prepared! Choose a Path, a Virtue, a Dominion and a Weapon!");
        return journeyRepository.save(journey);
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
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        int id = user.getActiveAvatarId();
        Avatar avatar = avatarService.findById(id);
        Journey journey = journeyRepository.findById(avatar.getActiveJourney());
        double avatarCurrentHp = avatar.getHp();
        double enemyCurrentHp = journey.getEnemy().getHp();
        while (avatarCurrentHp > 0 && enemyCurrentHp > 0) {
            enemyCurrentHp -= calculateAvatarDamage();
            avatarCurrentHp -= (journey.getEnemy().getDamage() + new Random().nextInt(51)) ;
        }
        if (avatarCurrentHp <= 0) {
            return "You lose!";
        }
        if (enemyCurrentHp <= 0) {
            return "You win!";
        }
        return "Martyr!";
    }

    public double calculateAvatarDamage() {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        int id = user.getActiveAvatarId();
        Avatar avatar = avatarService.findById(id);
        Weapon weapon = avatar.getWeapon();
        double baseAttack = avatar.getAttack() + weapon.getAtk();
        boolean isCritical = new Random().nextInt(101) < weapon.getCrit();
        if (isCritical) {
            baseAttack *= 1.5;
            System.out.println("Critical hit!");
        }
        double magicBonus = avatar.getMagic() * weapon.getMagicPercent();
        double totalDamage = baseAttack + magicBonus;
        return totalDamage;
    }
}
