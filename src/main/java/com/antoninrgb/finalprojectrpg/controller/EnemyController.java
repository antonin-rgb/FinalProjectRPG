package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.model.Enemy;
import com.antoninrgb.finalprojectrpg.service.EnemyService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/enemy")
public class EnemyController {

    private final EnemyService enemyService;

    public EnemyController (EnemyService enemyService) {
        this.enemyService = enemyService;
    }

    @GetMapping
    public List<Enemy> getAll() {
        return enemyService.findAllEnemies();
    }

    @PostMapping("/create")
    public Enemy create(@RequestBody Enemy enemy) {
        return enemyService.save(enemy);
    }

}
