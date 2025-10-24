package com.antoninrgb.finalprojectrpg.controller;

import com.antoninrgb.finalprojectrpg.service.PlayerService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
}
