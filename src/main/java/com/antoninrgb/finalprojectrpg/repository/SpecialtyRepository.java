package com.antoninrgb.finalprojectrpg.repository;
import com.antoninrgb.finalprojectrpg.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Integer> {

    Specialty findById(int id);

    Specialty findByName(String name);
}
