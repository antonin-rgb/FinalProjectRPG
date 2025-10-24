package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.model.Battle;
import com.antoninrgb.finalprojectrpg.service.BattleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/battle")
public class BattleController {

    private final BattleService battleService;

    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @GetMapping
    public List<Battle> getAll() {
        return battleService.findAllBattles();
    }

    @PostMapping("/create")
    public Battle create(@RequestBody Battle battle) {
        return battleService.save(battle);
    }
}
