package com.antoninrgb.finalprojectrpg.repository;
import com.antoninrgb.finalprojectrpg.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Integer> {

    Player findById(int id);
}
