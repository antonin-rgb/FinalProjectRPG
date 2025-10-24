package com.antoninrgb.finalprojectrpg.controller;

import com.antoninrgb.finalprojectrpg.service.EnemyService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/enemy")
public class EnemyController {

    private final EnemyService enemyService;

    public EnemyController (EnemyService enemyService) {
        this.enemyService = enemyService;
    }
}
