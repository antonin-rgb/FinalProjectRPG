package com.antoninrgb.finalprojectrpg.controller;

import com.antoninrgb.finalprojectrpg.service.DominionService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/dominion")
public class DominionController {

    private final DominionService dominionService;

    public DominionController(DominionService dominionService) {
        this.dominionService = dominionService;
    }
}
