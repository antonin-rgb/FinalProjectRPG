package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Enemy;
import com.antoninrgb.finalprojectrpg.repository.EnemyRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnemyService {

    private final EnemyRepository enemyRepository;

    public EnemyService(EnemyRepository enemyRepository) {
        this.enemyRepository = enemyRepository;
    }

    public List<Enemy> findAllEnemies() {
        return enemyRepository.findAll();
    }

    public Enemy save(Enemy enemy) {
        return enemyRepository.save(enemy);
    }


}
