package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.service.PathService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/path")
public class PathController {

    private final PathService pathService;

    public PathController(PathService pathService) {
        this.pathService = pathService;
    }
}
