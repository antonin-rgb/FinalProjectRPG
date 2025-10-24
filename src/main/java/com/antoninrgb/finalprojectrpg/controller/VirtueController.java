package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.model.Virtue;
import com.antoninrgb.finalprojectrpg.service.VirtueService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Repository("/virtue")
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
