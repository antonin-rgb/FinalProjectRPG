package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Player;
import com.antoninrgb.finalprojectrpg.repository.PlayerRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepo playerRepo;

    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public List<Player> findAllPlayers() {
        return playerRepo.findAll();
    }

    public Player save(Player player) {
        return playerRepo.save(player);
    }
}
