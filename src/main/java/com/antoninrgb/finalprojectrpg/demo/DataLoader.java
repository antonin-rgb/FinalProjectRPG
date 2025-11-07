package com.antoninrgb.finalprojectrpg.demo;
import static com.antoninrgb.finalprojectrpg.enums.EnemyType.*;
import static com.antoninrgb.finalprojectrpg.enums.SpecialtyType.*;
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
    private final EnemyService enemyService;
    private final WeaponService weaponService;


    @Override
    public void run(String... args) throws Exception {
        roleService.save(new Role("ROLE_USER"));
        roleService.save(new Role("ROLE_ADMIN"));

        userService.saveUser(new User("salvatore", "1234"));
        userService.saveUser(new User("antonino", "1234"));

        roleService.addRoleToUser("salvatore", "ROLE_USER");
        roleService.addRoleToUser("antonino", "ROLE_ADMIN");

        // Creating some specialties, i.e. special attributes of dominions and virtues.
        specialtyService.save(new Specialty("Protector's endurance", HP_BUFF, 30.0));
        specialtyService.save(new Specialty("Cosmic awareness", MAGIC_BUFF, 50.0));
        specialtyService.save(new Specialty("Castle's blessing", HP_BUFF, 30.0));
        specialtyService.save(new Specialty("Scorching earth", HP_DEBUFF, 20.0));
        specialtyService.save(new Specialty("Headhunter territory", ATK_BUFF, 20.0));
        specialtyService.save(new Specialty("Coup de grâce", STEALTH_ATK, 50.0));

        // Creating some paths, i.e. the path the avatar takes to fulfil their destiny.
        pathService.save(new Path("Wizard", "Bearer of wisdom, bender of the incomprehensible.", 30.0, 10.0, 50.0));
        pathService.save(new Path("Soldier", "Honour and brute force - protect or conquer.", 50.0, 30.0, 10.0));
        pathService.save(new Path("Ranger", "Sly, elusive, agile.", 10.0, 50.0, 30.0));

        // Creating some virtues, i.e. what drives the avatar's action and enhances its abilities.
        virtueService.save(new Virtue("Courage", "Gain sacred protection to aid you in battle."));
        specialtyService.addSpecialtyToVirtue("Courage", "Protector's endurance");

        virtueService.save(new Virtue("Intelligence", "Unlock the secrets of the universe."));
        specialtyService.addSpecialtyToVirtue("Intelligence", "Cosmic awareness");

        virtueService.save(new Virtue("Cunning", "Elude your foes."));
        specialtyService.addSpecialtyToVirtue("Cunning", "Coup de grâce");

        // Creating some dominions, i.e. the environment of the avatar's journey.
        Dominion sunnyPrairie = new Dominion("Sunny Prairie", "Just outside the castle, a beatiful expanse of grass hosts small critters, delicious fruit and cute predators.");
        sunnyPrairie.setSpecialty(specialtyService.findByName("Castle's blessing"));
        dominionService.save(sunnyPrairie);

        Dominion urticaJungle = new Dominion("Urtica Jungle", "Just outside the castle, a beatiful expanse of grass hosts small critters, delicious fruit and cute predators.");
        urticaJungle.setSpecialty(specialtyService.findByName("Headhunter territory"));
        dominionService.save(urticaJungle);

        Dominion deathboundVolcano = new Dominion("Deathbound Volcano", "Just outside the castle, a beatiful expanse of grass hosts small critters, delicious fruit and cute predators.");
        deathboundVolcano.setSpecialty(specialtyService.findByName("Scorching earth"));
        dominionService.save(deathboundVolcano);

        Dominion astronomerLab = new Dominion("Astronomer's Lab", "Just outside the castle, a beatiful expanse of grass hosts small critters, delicious fruit and cute predators.");
        astronomerLab.setSpecialty(specialtyService.findByName("Cosmic awareness"));
        dominionService.save(astronomerLab);

        // Creating some enemies that will be assigned to a dominion and that our avatar will face.
        Enemy prairieFox = new Enemy("Prairie Fox", "cute little fox", GOON, 30.0, 0.0);
        prairieFox.setDominion(dominionService.findByName("Sunny prairie"));
        enemyService.save(prairieFox);
        Enemy rosebud = new Enemy("Rosebud Wereseed", "seed from the Hope Rose that has been cursed", GOON, 20.0,20.0);
        rosebud.setDominion(dominionService.findByName("Sunny prairie"));
        enemyService.save(rosebud);
        Enemy cursedFoxFox = new Enemy("Cursed Fox", "something that doesn't remind you at all of a cute little fox", GOON, 50.0,0.0);
        cursedFoxFox.setDominion(dominionService.findByName("Sunny prairie"));
        enemyService.save(cursedFoxFox);
        Enemy rhynobull = new Enemy("Rhynobull", "docile guardian of the sunny prairie", BOSS, 200.0, 60.0);
        rhynobull.setDominion(dominionService.findByName("Sunny prairie"));
        enemyService.save(rhynobull);

        Enemy feline = new Enemy("Feline Stalker", "inhabitant of the forest, merciless when hungry", GOON, 50.0, 0.0);
        feline.setDominion(dominionService.findByName("Urtica Jungle"));
        enemyService.save(feline);
        Enemy killerplant = new Enemy("Killerplant", "#", GOON, 50.0, 0.0);
        killerplant.setDominion(dominionService.findByName("Urtica Jungle"));
        enemyService.save(killerplant);
        Enemy voidCougar = new Enemy("Voidcougar", "#", GOON, 50.0,  0.0);
        voidCougar.setDominion(dominionService.findByName("Urtica Jungle"));
        enemyService.save(voidCougar);

        Enemy scorchedPebble = new Enemy("Scorched Pebble", "#", GOON, 50.0,  10.0);
        scorchedPebble.setDominion(dominionService.findByName("Deathbound volcano"));
        enemyService.save(scorchedPebble);
        Enemy seismicMudkip = new Enemy("Seismic Mudkip", "#", GOON, 200.0,00.0);
        seismicMudkip.setDominion(dominionService.findByName("Deathbound volcano"));
        enemyService.save(seismicMudkip);
        Enemy lavaShielder = new Enemy("Lava Shielder", "#", GOON, 50.0,0.0);
        lavaShielder.setDominion(dominionService.findByName("Deathbound volcano"));
        enemyService.save(lavaShielder);

        Enemy astrologerZealot = new Enemy("Astrologer Zealot", "#", GOON, 50.0,0.0);
        astrologerZealot.setDominion(dominionService.findByName("Astronomer's Lab"));
        enemyService.save(astrologerZealot);
        Enemy zodiacSpectre = new Enemy("Zodiac Spectre", "#", GOON, 50.0,0.0);
        zodiacSpectre.setDominion(dominionService.findByName("Astronomer's Lab"));
        enemyService.save(zodiacSpectre);
        Enemy iridescentSnakedrake = new Enemy("Iridescent Snakedrake", "#", BOSS, 900.0,500.0);
        iridescentSnakedrake.setDominion(dominionService.findByName("Astronomer's Lab"));
        enemyService.save(iridescentSnakedrake);

        // Creating some weapons to use in battle.
        Weapon reaper = new Weapon("Reaper Bowknife", "description",20.0,20.0,70.0);
        weaponService.save(reaper);

        Weapon cobalt = new Weapon("Cobalt Staves", "description",0.0,50.0,0.0);
        weaponService.save(cobalt);

        Weapon solar = new Weapon("Solar Shield", "description",30.0,30.0,30.0);
        weaponService.save(solar);

        // Creating an example of avatar.



    }
}