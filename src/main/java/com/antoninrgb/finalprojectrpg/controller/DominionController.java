package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.model.Dominion;
import com.antoninrgb.finalprojectrpg.service.DominionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dominion")
public class DominionController {

    private final DominionService dominionService;

    public DominionController(DominionService dominionService) {
        this.dominionService = dominionService;
    }

    @GetMapping
    public List<Dominion> getAll() {
        return dominionService.findAllDominions();
    }

    @PostMapping("/create")
    public Dominion create(@RequestBody Dominion dominion) {
        return dominionService.save(dominion);
    }
}
