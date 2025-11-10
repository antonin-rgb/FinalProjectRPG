package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.exception.ResourceNotFoundException;
import com.antoninrgb.finalprojectrpg.model.*;
import com.antoninrgb.finalprojectrpg.model.Avatar;
import com.antoninrgb.finalprojectrpg.repository.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvatarService {

    private final AvatarRepository avatarRepository;
    private final PathService pathService;
    private final VirtueService virtueService;
    private final WeaponService weaponService;
    private final UserService userService;

    public AvatarService(AvatarRepository avatarRepository, PathService pathService, VirtueService virtueService, WeaponService weaponService, UserService userService) {
        this.avatarRepository = avatarRepository;
        this.pathService = pathService;
        this.virtueService = virtueService;
        this.weaponService = weaponService;
        this.userService = userService;
    }

    public List<Avatar> findAllAvatars() {
        return avatarRepository.findAll();
    }

    /* Upon creating a new player, an inventory is automatically created with a set amount of gold and assigned to the same player. */
    public Avatar save(Avatar avatar) {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        avatar.setUser(user);
        return avatarRepository.save(avatar);
    }

    public String chooseActiveAvatar(int avatarId) {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setActiveAvatarId(avatarId);
        userService.saveUser(user);
        return avatarRepository.findById(avatarId).getNickname() + "...\n...your journey awaits...\n\nTime to get prepared! Choose a Dominion, a Path, a Virtue and a Weapon!";
    }

    public Avatar assignPath(int pathId) {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        int id = user.getActiveAvatarId();
        Avatar avatar = avatarRepository.findById(id);
        Path path = pathService.findById(pathId);
        if (avatar.getPath() != null) {
            throw new IllegalStateException("Character already has a Path assigned.");
        } else {
            avatar.setPath(path);
            avatar.setHp(avatar.getHp() + path.getHp_bonus());
            avatar.setAttack(avatar.getAttack() + path.getAttack_bonus());
            avatar.setMagic(avatar.getMagic() + path.getMagic_bonus());
            return avatarRepository.save(avatar);
        }
    }

    public Avatar assignVirtue(int virtueId) {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        int id = user.getActiveAvatarId();
        Avatar avatar = avatarRepository.findById(id);
        Virtue virtue = virtueService.findById(virtueId);
        if (avatar.getVirtue() != null) {
            throw new IllegalStateException("Character already has a Virtue assigned.");
        } else {
            avatar.setVirtue(virtue);
            return avatarRepository.save(avatar);
        }
    }

    public Avatar assignWeapon(int weaponId) {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        int id = user.getActiveAvatarId();
        Avatar avatar = avatarRepository.findById(id);
        Weapon weapon = weaponService.findById(weaponId);
        if (avatar.getWeapon() != null) {
            throw new ResourceNotFoundException("You already chose a dominion.");
        } else {
            avatar.setWeapon(weapon);
            return avatarRepository.save(avatar);
        }
    }

    public Avatar findById(int id) {
        return avatarRepository.findById(id);
    }

}
