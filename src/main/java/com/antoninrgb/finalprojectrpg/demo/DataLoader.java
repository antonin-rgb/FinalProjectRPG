package com.antoninrgb.finalprojectrpg.demo;
import static com.antoninrgb.finalprojectrpg.enums.SpecialtyType.*;
import com.antoninrgb.finalprojectrpg.model.*;
import com.antoninrgb.finalprojectrpg.service.*;
import jakarta.transaction.Transactional;
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

        /* Creating some specialties, i.e. special attributes of dominions and virtues. */
        specialtyService.save(new Specialty("Protector's endurance", HP_BUFF, 30.0));
        specialtyService.save(new Specialty("Cosmic awareness", MAGIC_BUFF, 50.0));
        specialtyService.save(new Specialty("Castle's blessing", HP_BUFF, 30.0));
        specialtyService.save(new Specialty("Scorching earth", HP_DEBUFF, 20.0));
        specialtyService.save(new Specialty("Headhunter territory", ATK_BUFF, 20.0));
        specialtyService.save(new Specialty("Coup de grâce", STEALTH_KILL, 50.0));

        /* Creating some paths, i.e. the path the avatar takes to fulfil their destiny. */
        pathService.save(new Path("Wizard", "Bearer of wisdom, bender of the incomprehensible.", 30.0, 10.0, 50.0));
        pathService.save(new Path("Soldier", "Honour and brute force - protect or conquer.", 50.0, 30.0, 10.0));
        pathService.save(new Path("Ranger", "Sly, elusive, agile.", 10.0, 50.0, 30.0));

        /* Creating some virtues, i.e. what drives the avatar's action and enhances its abilities. */
        virtueService.save(new Virtue("Courage", "Gain sacred protection to aid you in battle."));
        specialtyService.addSpecialtyToVirtue("Courage", "Protector's endurance");
        specialtyService.addSpecialtyToVirtue("Courage", "Castle's blessing");

        virtueService.save(new Virtue("Intelligence", "Unlock the secrets of the universe."));
        specialtyService.addSpecialtyToVirtue("Intelligence", "Cosmic awareness");

        virtueService.save(new Virtue("Cunning", "Elude your foes."));
        specialtyService.addSpecialtyToVirtue("Cunning", "Coup de grâce");
        specialtyService.addSpecialtyToVirtue("Cunning", "Headhunter territory");

        /* Creating some dominions, i.e. the environment of the avatar's journey. */
        Dominion sunnyPrairie = new Dominion("Sunny Prairie", "Just outside the castle, a beatiful expanse of grass hosts small critters, delicious fruit and cute predators.");
        sunnyPrairie.setSpecialty(specialtyService.findByName("Castle's blessing"));
        dominionService.save(sunnyPrairie);

        Dominion astronomerLab = new Dominion("Astronomer's Lab", "Just outside the castle, a beatiful expanse of grass hosts small critters, delicious fruit and cute predators.");
        astronomerLab.setSpecialty(specialtyService.findByName("Cosmic awareness"));
        dominionService.save(astronomerLab);

        Dominion urticaJungle = new Dominion("Urtica Jungle", "Just outside the castle, a beatiful expanse of grass hosts small critters, delicious fruit and cute predators.");
        urticaJungle.setSpecialty(specialtyService.findByName("Headhunter territory"));
        dominionService.save(urticaJungle);

        Dominion deathboundVolcano = new Dominion("Deathbound Volcano", "Just outside the castle, a beatiful expanse of grass hosts small critters, delicious fruit and cute predators.");
        deathboundVolcano.setSpecialty(specialtyService.findByName("Scorching earth"));
        dominionService.save(deathboundVolcano);

        /* Creating an example of avatar. */
        Avatar tutorialWiseman = new Avatar("Tutorial Wiseman");
        tutorialWiseman.setVirtue(virtueService.findByName("Courage"));
        tutorialWiseman.setDominion(dominionService.findByName("Sunny prairie"));
        avatarService.save(tutorialWiseman);
        avatarService.assignPath(1,1);


    }
}