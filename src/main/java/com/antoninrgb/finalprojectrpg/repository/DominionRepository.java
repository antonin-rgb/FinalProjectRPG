package com.antoninrgb.finalprojectrpg.repository;

import com.antoninrgb.finalprojectrpg.model.Dominion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DominionRepository extends JpaRepository<Dominion, Integer> {

    Dominion findById(int id);

    Dominion findByName(String name);
}
