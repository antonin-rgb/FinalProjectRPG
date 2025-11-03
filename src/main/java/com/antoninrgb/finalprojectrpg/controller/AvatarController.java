package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.model.Avatar;
import com.antoninrgb.finalprojectrpg.model.User;
import com.antoninrgb.finalprojectrpg.service.AvatarService;
import com.antoninrgb.finalprojectrpg.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import java.util.List;

@RestController
@RequestMapping("/avatar")
public class AvatarController {

    private final AvatarService avatarService;
    private final UserService userService;

    public AvatarController(AvatarService avatarService, UserService userService) {
        this.avatarService = avatarService;
        this.userService = userService;
    }

    @GetMapping
    public List<Avatar> getAll() {
        return avatarService.findAllAvatars();
    }

    // this creates an avatar connected to the currently logged in user
    @PostMapping("/create")
    public Avatar create(@RequestBody Avatar avatar, Authentication authentication) {
        String username = authentication.getName();
        User user = userService.getUser(username);
        avatar.setUser(user);
        return avatarService.save(avatar);
    }

    @PatchMapping("{avatarId}/path/{pathId}")
    public Avatar choosePath(@PathVariable int avatarId, @PathVariable int pathId) {
        return avatarService.assignPath(avatarId, pathId);
    }

    @PatchMapping("{avatarId}/virtue/{virtueId}")
    public Avatar chooseVirtue(@PathVariable int avatarId, @PathVariable int virtueId) {
        return avatarService.assignVirtue(avatarId, virtueId);
    }

    @PatchMapping("{avatarId}/dominion/{dominionId}")
    public Avatar chooseDominion(@PathVariable int avatarId, @PathVariable int dominionId) {
        return avatarService.assignDominion(avatarId, dominionId);
    }


}
