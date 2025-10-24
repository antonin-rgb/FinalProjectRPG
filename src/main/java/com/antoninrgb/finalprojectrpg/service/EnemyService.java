package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Enemy;
import com.antoninrgb.finalprojectrpg.repository.EnemyRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnemyService {

    private final EnemyRepo enemyRepo;

    public EnemyService(EnemyRepo enemyRepo) {
        this.enemyRepo = enemyRepo;
    }

    public List<Enemy> findAllEnemies() {
        return enemyRepo.findAll();
    }

    public Enemy save(Enemy enemy) {
        return enemyRepo.save(enemy);
    }


}
