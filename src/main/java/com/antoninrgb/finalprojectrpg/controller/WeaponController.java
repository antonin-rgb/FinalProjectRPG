package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.model.Weapon;
import com.antoninrgb.finalprojectrpg.service.WeaponService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/weapon")
public class WeaponController {

    private final WeaponService weaponService;

    public WeaponController (WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @GetMapping
    public List<Weapon> getAll() {
        return weaponService.findAllWeapons();
    }

    @PostMapping("/create")
    public Weapon create(@RequestBody Weapon weapon) {
        return weaponService.save(weapon);
    }

}
