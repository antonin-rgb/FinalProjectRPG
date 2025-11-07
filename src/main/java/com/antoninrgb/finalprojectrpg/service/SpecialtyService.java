package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Dominion;
import com.antoninrgb.finalprojectrpg.model.Specialty;
import com.antoninrgb.finalprojectrpg.model.Virtue;
import com.antoninrgb.finalprojectrpg.repository.DominionRepository;
import com.antoninrgb.finalprojectrpg.repository.SpecialtyRepository;
import com.antoninrgb.finalprojectrpg.repository.VirtueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;
    private final VirtueRepository virtueRepository;
    private final DominionRepository dominionRepository;

    public SpecialtyService(SpecialtyRepository specialtyRepository, VirtueRepository virtueRepository, DominionRepository dominionRepository) {
        this.specialtyRepository = specialtyRepository;
        this.virtueRepository = virtueRepository;
        this.dominionRepository = dominionRepository;
    }

    public List<Specialty> findAllSpecialties() {
        return specialtyRepository.findAll();
    }

    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    public Specialty findByName(String name) {
        return specialtyRepository.findByName(name);
    }

    public void addSpecialtyToVirtue(String virtueName, String name) {
        Virtue virtue = virtueRepository.findByName(virtueName);
        Specialty specialty = specialtyRepository.findByName(name);
        if (virtue == null) {
            throw new IllegalArgumentException("Virtue not found: " + virtueName);
        }
        if (specialty == null) {
            throw new IllegalArgumentException("Specialty not found: " + name);
        }

        virtue.setSpecialty(specialty);
        virtueRepository.save(virtue);
    }

    public void addSpecialtyToDominion(String dominionName, String name) {
        Dominion dominion = dominionRepository.findByName(dominionName);
        Specialty specialty = specialtyRepository.findByName(name);
        if (dominion == null) {
            throw new IllegalArgumentException("Dominion not found: " + dominionName);
        }
        if (specialty == null) {
            throw new IllegalArgumentException("Specialty not found: " + name);
        }
        dominion.setSpecialty(specialty);
        dominionRepository.save(dominion);
    }
}
