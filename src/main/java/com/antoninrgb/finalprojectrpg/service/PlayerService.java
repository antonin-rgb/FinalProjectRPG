package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.repository.PlayerRepo;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepo playerRepo;

    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }
}
