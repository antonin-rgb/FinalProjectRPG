package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.repository.WeaponRepo;
import org.springframework.stereotype.Service;

@Service
public class WeaponService {

    private final WeaponRepo weaponRepo;

    public WeaponService(WeaponRepo weaponRepo) {
        this.weaponRepo = weaponRepo;
    }
}
