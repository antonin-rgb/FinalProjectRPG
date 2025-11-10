package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.model.Dominion;
import com.antoninrgb.finalprojectrpg.model.Journey;
import com.antoninrgb.finalprojectrpg.service.JourneyService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/journey")
public class JourneyController {

    private final JourneyService journeyService;

    public JourneyController(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @GetMapping
    public List<Journey> getAll() {
        return journeyService.findAllBattles();
    }

    @PostMapping("/start")
    public String create(@RequestBody Journey journey) {
        return journeyService.save(journey);
    }

    @PatchMapping("/choose/dominion/{dominionId}")
    public Journey chooseDominion(@PathVariable int dominionId) {
        return journeyService.chooseDominion(dominionId);
    }

    @GetMapping("/battle")
    public String toBattle() {
        return journeyService.toBattle();
    }
}
