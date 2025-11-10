package com.antoninrgb.finalprojectrpg.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Weapon {

    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private double attack;
    @Getter @Setter private double magicPercent;
    @Getter @Setter private double crit;

    /* Constructors, getters, setters */
    public Weapon(String name, String description, double atk, double magicPercent, double crit) {
        this.name = name;
        this.description = description;
        this.attack = atk;
        this.magicPercent = magicPercent;
        this.crit = crit;
    }

    public Weapon() {
    }

}
