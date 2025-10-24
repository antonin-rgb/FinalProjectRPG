package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Weapon;
import com.antoninrgb.finalprojectrpg.repository.WeaponRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponService {

    private final WeaponRepo weaponRepo;

    public WeaponService(WeaponRepo weaponRepo) {
        this.weaponRepo = weaponRepo;
    }

    public List<Weapon> findAllWeapons() {
        return weaponRepo.findAll();
    }

    public Weapon save(Weapon weapon) {
        return weaponRepo.save(weapon);
    }

}
