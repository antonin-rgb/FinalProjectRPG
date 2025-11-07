package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.model.Avatar;
import com.antoninrgb.finalprojectrpg.model.Journey;
import com.antoninrgb.finalprojectrpg.model.User;
import com.antoninrgb.finalprojectrpg.repository.UserRepository;
import com.antoninrgb.finalprojectrpg.service.AvatarService;
import com.antoninrgb.finalprojectrpg.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import java.util.List;

@RestController
@RequestMapping("/avatar")
public class AvatarController {

    private final AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @GetMapping
    public List<Avatar> getAll() {
        return avatarService.findAllAvatars();
    }

    // this creates an avatar connected to the currently logged-in user
    @PostMapping("/create")
    public Avatar create(@RequestBody Avatar avatar, Authentication authentication) {
        return avatarService.save(avatar);
    }

    @PatchMapping("/choose/{avatarId}")
    public String chooseActiveAvatar(@PathVariable int avatarId) {
        return avatarService.chooseActiveAvatar(avatarId);
    }

    @PatchMapping("/choose/path/{pathId}")
    public Avatar choosePath(@PathVariable int pathId) {
        return avatarService.assignPath(pathId);
    }

    @PatchMapping("/choose/virtue/{virtueId}")
    public Avatar chooseVirtue(@PathVariable int virtueId) {
        return avatarService.assignVirtue(virtueId);
    }

    @PatchMapping("/choose/weapon/{weaponId}")
    public Avatar chooseWeapon(@PathVariable int weaponId) {
        return avatarService.assignWeapon(weaponId);
    }

}
