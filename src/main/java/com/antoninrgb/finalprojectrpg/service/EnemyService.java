package com.antoninrgb.finalprojectrpg.service;

import com.antoninrgb.finalprojectrpg.repository.EnemyRepo;
import org.springframework.stereotype.Service;

@Service
public class EnemyService {

    private final EnemyRepo enemyRepo;

    public EnemyService(EnemyRepo enemyRepo) {
        this.enemyRepo = enemyRepo;
    }
}
