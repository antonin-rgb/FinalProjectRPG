package com.antoninrgb.finalprojectrpg.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Avatar {

    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    @Setter @Getter private String nickname;
    @Setter @Getter private double hp = 500;
    @Setter @Getter private double attack = 20;
    @Setter @Getter private double magic = 0;
    @Setter @Getter @ManyToOne private Path path;
    @Setter @Getter @ManyToOne private Virtue virtue;
    @Setter @Getter @ManyToOne private Weapon weapon;
    @Setter @Getter @OneToMany(mappedBy = "avatar") private List<Journey> journeys = new ArrayList<>();
    @Setter @Getter private int activeJourney;
    @Setter @Getter @ManyToOne @JoinColumn(name = "user_id") @JsonIgnore private User user;

    /* Constructors, getters, setters */
    public Avatar(String nickname, double hp, double attack, double magic, Path path, Virtue virtue, Weapon weapon, List<Journey> journeys, int activeJourney, User user) {
        this.nickname = nickname;
        this.hp = hp;
        this.attack = attack;
        this.magic = magic;
        this.path = path;
        this.virtue = virtue;
        this.weapon = weapon;
        this.journeys = journeys;
        this.activeJourney = activeJourney;
        this.user = user;
    }

    public Avatar() {
    }

    public Avatar(String nickname) {
        this.nickname = nickname;
    }


}
