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
        specialtyService.save(new Specialty("Coup de grâce", STEALTH_ATK, 0.5));

        // Creating some paths, i.e. the path the avatar takes to fulfil their destiny.
        pathService.save(new Path("Wizard", "Bearer of wisdom, bender of the incomprehensible.", 30.0, 10.0, 50.0));
        pathService.save(new Path("Soldier", "Honour and brute force - protect or conquer.", 50.0, 30.0, 10.0));
        pathService.save(new Path("Ranger", "Sly, elusive, agile.", 10.0, 50.0, 30.0));

        // Creating some virtues, i.e. what drives the avatar's action and enhances its abilities.
        virtueService.save(new Virtue("Courage", "Gain sacred protection to aid you in battle. +30 HP"));
        specialtyService.addSpecialtyToVirtue("Courage", "Protector's endurance");

        virtueService.save(new Virtue("Intelligence", "Unlock the secrets of the universe. +50 magic"));
        specialtyService.addSpecialtyToVirtue("Intelligence", "Cosmic awareness");

        virtueService.save(new Virtue("Cunning", "Elude your foes. +50% stealth attack"));
        specialtyService.addSpecialtyToVirtue("Cunning", "Coup de grâce");

        // Creating some dominions, i.e. the environment of the avatar's journey.
        Dominion sunnyPrairie = new Dominion("Sunny Prairie", "Beyond the castle walls stretches a golden sea of grass, teeming with gentle creatures and small predators. Locals whisper of an ancient beast that still lurks beneath the sunlit fields.");
        sunnyPrairie.setSpecialty(specialtyService.findByName("Castle's blessing"));
        dominionService.save(sunnyPrairie);

        Dominion urticaJungle = new Dominion("Urtica Jungle", "A dense labyrinth of wilderness where every leaf hides fangs and every flower drips venom.");
        urticaJungle.setSpecialty(specialtyService.findByName("Headhunter territory"));
        dominionService.save(urticaJungle);

        Dominion deathboundVolcano = new Dominion("Deathbound Volcano", "A blistering realm of lava and ash where molten beasts roam and the very rocks awaken.");
        deathboundVolcano.setSpecialty(specialtyService.findByName("Scorching earth"));
        dominionService.save(deathboundVolcano);

        Dominion astronomerLab = new Dominion("Astronomer's Lab", "Ruins of what was once a beacon of knowledge, turned into a portal into the universe and its deepest secrets.");
        astronomerLab.setSpecialty(specialtyService.findByName("Cosmic awareness"));
        dominionService.save(astronomerLab);

        // Creating some enemies that will be assigned to a dominion and that our avatar will face.
        Enemy prairieFox = new Enemy("Prairie Fox", "A playful little fox.", GOON, 30.0, 0.0);
        prairieFox.setDominion(dominionService.findByName("Sunny prairie"));
        enemyService.save(prairieFox);
        Enemy rosebud = new Enemy("Rosebud Wereseed", "A twisted seed of the prairie’s sacred flower, cursed to sprout fangs instead of petals.", GOON, 20.0,20.0);
        rosebud.setDominion(dominionService.findByName("Sunny prairie"));
        enemyService.save(rosebud);
        Enemy cursedFoxFox = new Enemy("Cursed Fox", "Once a gentle creature of the fields, now consumed by dark whispers that fire its thirst for blood.", GOON, 50.0,0.0);
        cursedFoxFox.setDominion(dominionService.findByName("Sunny prairie"));
        enemyService.save(cursedFoxFox);
        Enemy rhynobull = new Enemy("Cursed Rhynobull", "The ancient guardian of the prairie, now veiled in shadow — its once-pure heart burns with a torment that keeps it hidden from the sky.", BOSS, 200.0, 60.0);
        rhynobull.setDominion(dominionService.findByName("Sunny prairie"));
        enemyService.save(rhynobull);

        Enemy feline = new Enemy("Feline Stalker", "A sleek predator of steel and fur, leaping across the branches and hunting with its shimmering cyber-eyes.", GOON, 50.0, 0.0);
        feline.setDominion(dominionService.findByName("Urtica Jungle"));
        enemyService.save(feline);
        Enemy vilebloom = new Enemy("Vilebloom", "A deceptively beautiful flower that feeds not on sunlight, but on the flesh of anything foolish enough to admire it.", GOON, 50.0, 0.0);
        vilebloom.setDominion(dominionService.findByName("Urtica Jungle"));
        enemyService.save(vilebloom);
        Enemy voidCougar = new Enemy("Voidcougar", "Born from the jungle’s deepest shadows, this spectral hunter moves between worlds, leaving only silence behind it.", GOON, 50.0,  0.0);
        voidCougar.setDominion(dominionService.findByName("Urtica Jungle"));
        enemyService.save(voidCougar);

        Enemy scorchedPebble = new Enemy("Lava Whip", "A living lash of molten fire that dances across the magma flows, scorching everything drawn to its glow.", GOON, 50.0,  10.0);
        scorchedPebble.setDominion(dominionService.findByName("Deathbound volcano"));
        enemyService.save(scorchedPebble);
        Enemy seismicMudkip = new Enemy("Seismic Mudkip", "A rocky, mud-born creature that can cause ground-crumbling tremors.", GOON, 200.0,00.0);
        seismicMudkip.setDominion(dominionService.findByName("Deathbound volcano"));
        enemyService.save(seismicMudkip);
        Enemy magmashielder = new Enemy("Magmashielder", "A towering sentinel of molten stone, forged to guard the volcano’s heart and the secrets cosmic secrets within it.", GOON, 50.0,0.0);
        magmashielder.setDominion(dominionService.findByName("Deathbound volcano"));
        enemyService.save(magmashielder);

        Enemy astrologerZealot = new Enemy("Astrologer Zealot", "Fanatics who destroyed the lab in divine fury, who think there is no place for the Astronomers' heresy.", GOON, 50.0,0.0);
        astrologerZealot.setDominion(dominionService.findByName("Astronomer's Lab"));
        enemyService.save(astrologerZealot);
        Enemy zodiacSpectre = new Enemy("Zodiac Spectre", "A splinter of zodiac power given form.", GOON, 50.0,0.0);
        zodiacSpectre.setDominion(dominionService.findByName("Astronomer's Lab"));
        enemyService.save(zodiacSpectre);
        Enemy iridescentSnakedrake = new Enemy("Iridescent Snakedrake", "Beyond the portal coils the radiant serpent of the sun.", BOSS, 900.0,500.0);
        iridescentSnakedrake.setDominion(dominionService.findByName("Astronomer's Lab"));
        enemyService.save(iridescentSnakedrake);

        // Creating some weapons to use in battle.
        Weapon reaper = new Weapon("Reaper Bowknife", "A curved hybrid between bow and blade, forged for silent kills — it hums with a faint whisper, as if hungry for its next soul.",20.0,20.0,0.7);
        weaponService.save(reaper);

        Weapon cobalt = new Weapon("Cobalt Staves", "Twin conduits of cosmic energy, channeling starlight into devastating arcs of pure astral power.",0.0,50.0,0.0);
        weaponService.save(cobalt);

        Weapon solar = new Weapon("Solar Shieldcannon", "A radiant barrier forged from fragments of a fallen star, blazing with the strength to reflect both flame and fury.",30.0,30.0,0.3);
        weaponService.save(solar);

        // Creating an example of avatar.



    }
}