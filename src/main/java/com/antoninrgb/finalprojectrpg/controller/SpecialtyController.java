package com.antoninrgb.finalprojectrpg.controller;

import com.antoninrgb.finalprojectrpg.service.SpecialtyService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/specialty")
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }
}
