package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Battle;
import com.antoninrgb.finalprojectrpg.repository.BattleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BattleService {

    private final BattleRepository battleRepository;

    public BattleService(BattleRepository battleRepository) {
        this.battleRepository = battleRepository;
    }

    public List<Battle> findAllBattles() {
        return battleRepository.findAll();
    }

    public Battle save(Battle battle) {
        return battleRepository.save(battle);
    }

}
