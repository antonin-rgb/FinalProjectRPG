package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.model.Path;
import com.antoninrgb.finalprojectrpg.model.Player;
import com.antoninrgb.finalprojectrpg.service.PathService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/path")
public class PathController {

    private final PathService pathService;

    public PathController(PathService pathService) {
        this.pathService = pathService;
    }

    @GetMapping
    public List<Path> getAll() {
        return pathService.findAllPaths();
    }

    @PostMapping("/create")
    public Path create(@RequestBody Path path) {
        return pathService.save(path);
    }

}
