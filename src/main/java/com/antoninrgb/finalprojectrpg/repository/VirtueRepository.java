package com.antoninrgb.finalprojectrpg.repository;

import com.antoninrgb.finalprojectrpg.model.Virtue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirtueRepository extends JpaRepository<Virtue, Integer> {

    Virtue findById(int id);

    Virtue findByName(String name);
}