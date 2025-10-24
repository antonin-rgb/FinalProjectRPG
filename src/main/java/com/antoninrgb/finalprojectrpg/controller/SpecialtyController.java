package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.model.Specialty;
import com.antoninrgb.finalprojectrpg.service.SpecialtyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialty")
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @GetMapping
    public List<Specialty> getAll() {
        return specialtyService.findAllSpecialties();
    }

    @PostMapping("/create")
    public Specialty create(@RequestBody Specialty specialty) {
        return specialtyService.save(specialty);
    }

}
