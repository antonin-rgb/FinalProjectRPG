package com.antoninrgb.finalprojectrpg.repository;
import com.antoninrgb.finalprojectrpg.model.Battle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleRepository extends JpaRepository<Battle, Integer> {
}


