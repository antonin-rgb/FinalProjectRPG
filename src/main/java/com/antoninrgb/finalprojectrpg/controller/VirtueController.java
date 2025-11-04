package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.model.Virtue;
import com.antoninrgb.finalprojectrpg.service.VirtueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/virtue")
public class VirtueController {

    private final VirtueService virtueService;

    public VirtueController(VirtueService virtueService) {
        this.virtueService = virtueService;
    }

    @GetMapping
    public List<Virtue> getAll() {
        return virtueService.findAllVirtues();
    }

    @PostMapping("/create")
    public Virtue create(@RequestBody Virtue virtue) {
        return virtueService.save(virtue);
    }

}
