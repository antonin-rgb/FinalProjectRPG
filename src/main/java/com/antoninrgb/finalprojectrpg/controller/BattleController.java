package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.service.BattleService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/battle")
public class BattleController {

    private final BattleService battleService;

    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }
}
