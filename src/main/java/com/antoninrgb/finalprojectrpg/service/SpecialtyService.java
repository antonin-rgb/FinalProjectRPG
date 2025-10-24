package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Specialty;
import com.antoninrgb.finalprojectrpg.repository.SpecialtyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyService {

    private final SpecialtyRepo specialtyRepo;

    public SpecialtyService(SpecialtyRepo specialtyRepo) {
        this.specialtyRepo = specialtyRepo;
    }

    public List<Specialty> findAllSpecialties() {
        return specialtyRepo.findAll();
    }

    public Specialty save(Specialty specialty) {
        return specialtyRepo.save(specialty);
    }
}
