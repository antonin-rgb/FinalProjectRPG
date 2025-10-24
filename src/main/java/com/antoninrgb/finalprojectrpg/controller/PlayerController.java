package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.model.Player;
import com.antoninrgb.finalprojectrpg.service.PlayerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAll() {
        return playerService.findAllPlayers();
    }

    @PostMapping("/create")
    public Player create(@RequestBody Player player) {
        return playerService.save(player);
    }


}
