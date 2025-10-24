package com.antoninrgb.finalprojectrpg.controller;

import com.antoninrgb.finalprojectrpg.service.WeaponService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/weapon")
public class WeaponController {

    private final WeaponService weaponService;

    public WeaponController (WeaponService weaponService) {
        this.weaponService = weaponService;
    }
}
