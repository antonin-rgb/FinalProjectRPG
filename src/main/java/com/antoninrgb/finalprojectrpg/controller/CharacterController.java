package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.model.Character;
import com.antoninrgb.finalprojectrpg.service.CharacterService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/player")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<Character> getAll() {
        return characterService.findAllPlayers();
    }

    @PostMapping("/create")
    public Character create(@RequestBody Character character) {
        return characterService.save(character);
    }

    @PatchMapping("/{playerId}/path/{pathId}")
    public Character choosePath(@PathVariable int playerId, @PathVariable int pathId) {
        return characterService.assignPath(playerId, pathId);
    }

    @PatchMapping("/{playerId}/virtue/{virtueId}")
    public Character chooseVirtue(@PathVariable int playerId, @PathVariable int virtueId) {
        return characterService.assignVirtue(playerId, virtueId);
    }

    @PatchMapping("/{playerId}/dominion/{dominionId}")
    public Character chooseDominion(@PathVariable int playerId, @PathVariable int dominionId) {
        return characterService.assignDominion(playerId, dominionId);
    }


}
