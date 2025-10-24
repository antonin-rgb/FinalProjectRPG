package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.repository.SpecialtyRepo;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyService {

    private final SpecialtyRepo specialtyRepo;

    public SpecialtyService(SpecialtyRepo specialtyRepo) {
        this.specialtyRepo = specialtyRepo;
    }
}
