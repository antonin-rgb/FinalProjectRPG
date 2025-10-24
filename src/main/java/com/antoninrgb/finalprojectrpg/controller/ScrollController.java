package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.service.ScrollService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/scroll")
public class ScrollController {

    private final ScrollService scrollService;

    public ScrollController(ScrollService scrollService) {
        this.scrollService = scrollService;
    }
}
