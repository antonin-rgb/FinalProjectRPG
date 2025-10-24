package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Battle;
import com.antoninrgb.finalprojectrpg.repository.BattleRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BattleService {

    private final BattleRepo battleRepo;

    public BattleService(BattleRepo battleRepo) {
        this.battleRepo = battleRepo;
    }

    public List<Battle> findAllBattles() {
        return battleRepo.findAll();
    }

    public Battle save(Battle battle) {
        return battleRepo.save(battle);
    }

}
