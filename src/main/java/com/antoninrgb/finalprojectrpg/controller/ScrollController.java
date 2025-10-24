package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.model.Scroll;
import com.antoninrgb.finalprojectrpg.service.ScrollService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/scroll")
public class ScrollController {

    private final ScrollService scrollService;

    public ScrollController(ScrollService scrollService) {
        this.scrollService = scrollService;
    }

    @GetMapping
    public List<Scroll> getAll() {
        return scrollService.findAllScrolls();
    }

    @PostMapping("/create")
    public Scroll create(@RequestBody Scroll scroll) {
        return scrollService.save(scroll);
    }

}
