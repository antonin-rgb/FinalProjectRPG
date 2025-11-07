package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Weapon;
import com.antoninrgb.finalprojectrpg.repository.WeaponRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponService {

    private final WeaponRepository weaponRepository;

    public WeaponService(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    public List<Weapon> findAllWeapons() {
        return weaponRepository.findAll();
    }

    public Weapon save(Weapon weapon) {
        return weaponRepository.save(weapon);
    }

    public Weapon findById(int id) {
        return weaponRepository.findById(id);
    }

}
