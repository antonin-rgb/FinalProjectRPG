package com.antoninrgb.finalprojectrpg.repository;

import com.antoninrgb.finalprojectrpg.model.Path;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathRepository extends JpaRepository<Path, Integer> {

    Path findById(int id);

    Path findByName(String name);
}
