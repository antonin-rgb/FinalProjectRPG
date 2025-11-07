package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Dominion;
import com.antoninrgb.finalprojectrpg.model.Enemy;
import com.antoninrgb.finalprojectrpg.repository.DominionRepository;
import com.antoninrgb.finalprojectrpg.repository.EnemyRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnemyService {

    private final EnemyRepository enemyRepository;
    private final DominionRepository dominionRepository;

    public EnemyService(EnemyRepository enemyRepository, DominionRepository dominionRepository) {
        this.enemyRepository = enemyRepository;
        this.dominionRepository = dominionRepository;
    }

    public List<Enemy> findAllEnemies() {
        return enemyRepository.findAll();
    }

    public Enemy save(Enemy enemy) {
        return enemyRepository.save(enemy);
    }

    public void addEnemyToDominion(String name, String dominionName) {
        Dominion dominion = dominionRepository.findByName(dominionName);
        Enemy enemy = enemyRepository.findByName(name);
        if (dominion == null) {
            throw new IllegalArgumentException("Dominion not found: " + dominionName);
        }
        if (enemy == null) {
            throw new IllegalArgumentException("Enemy not found: " + name);
        }
        enemy.setDominion(dominion);
        enemyRepository.save(enemy);
    }

    public Enemy findByName(String name) {
        return enemyRepository.findByName(name);
    }

}
