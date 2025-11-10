package com.antoninrgb.finalprojectrpg.repository;
import com.antoninrgb.finalprojectrpg.model.Enemy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnemyRepository extends JpaRepository<Enemy, Integer> {

    List<Enemy> findByDominionId(int id);

    Enemy findByName(String name);

}
