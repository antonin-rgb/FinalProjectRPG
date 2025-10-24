package com.antoninrgb.finalprojectrpg.controller;

import com.antoninrgb.finalprojectrpg.service.VirtueService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository("/virtue")
public class VirtueController {

    private final VirtueService virtueService;

    public VirtueController(VirtueService virtueService) {
        this.virtueService = virtueService;
    }
}
