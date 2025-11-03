package com.antoninrgb.finalprojectrpg.demo;
import static com.antoninrgb.finalprojectrpg.enums.SpecialtyType.*;
import static com.antoninrgb.finalprojectrpg.enums.Element.*;
import com.antoninrgb.finalprojectrpg.model.*;
import com.antoninrgb.finalprojectrpg.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserService userService;
    private final RoleService roleService;
    private final AvatarService avatarService;
    private final PathService pathService;
    private final VirtueService virtueService;
    private final DominionService dominionService;
    private final SpecialtyService specialtyService;


    @Override
    public void run(String... args) throws Exception {
        roleService.save(new Role("ROLE_USER"));
        roleService.save(new Role("ROLE_ADMIN"));

        userService.saveUser(new User("salvatore", "1234"));
        userService.saveUser(new User("antonino", "1234"));

        roleService.addRoleToUser("salvatore", "ROLE_USER");
        roleService.addRoleToUser("antonino", "ROLE_ADMIN");

        specialtyService.save(new Specialty("Protector's endurance", HP_BUFF, 50.0));
        specialtyService.save(new Specialty("Mystic protection", MAGIC_BUFF, 20.0));
        specialtyService.save(new Specialty("Castle's blessing", HP_BUFF, 30.0));

        pathService.save(new Path("Wizard", "Bearer of wisdom, bender of the incomprehensible.", 10.0, 0.0, 50.0));

        Virtue protector = new Virtue("Protector", "Protect nature and its inhabitants.");
        protector.getSpecialties().add(specialtyService.findByName("Protector's endurance"));
        protector.getSpecialties().add(specialtyService.findByName("Mystic protection"));
        virtueService.save(protector);

        Dominion sunnyPrairie = new Dominion("Sunny prairie", "Just outside the castle, a beatiful expanse of grass hosts small critters, delicious fruit and cute predators.", NORMAL);
        sunnyPrairie.setSpecialty(specialtyService.findByName("Castle's blessing"));
        dominionService.save(sunnyPrairie);

        Avatar tutorialWiseman = new Avatar("Tutorial Wiseman");
        tutorialWiseman.setVirtue(virtueService.findByName("Protector"));
        tutorialWiseman.setDominion(dominionService.findByName("Sunny prairie"));
        avatarService.save(tutorialWiseman);
        avatarService.assignPath(1,1);


    }
}