package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.repository.BattleRepo;
import org.springframework.stereotype.Service;

@Service
public class BattleService {

    private final BattleRepo battleRepo;

    public BattleService(BattleRepo battleRepo) {
        this.battleRepo = battleRepo;
    }
}
