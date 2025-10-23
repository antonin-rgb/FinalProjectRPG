package com.antoninrgb.finalprojectrpg.model;
import jakarta.persistence.*;

@Entity
public class Path {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private double hp_bonus;

    private double attack_bonus;

    private double magic_bonus;

    /* Constructors, getters, setters */
    public Path(String name, String description, double hp_bonus, double attack_bonus, double magic_bonus) {
        this.name = name;
        this.description = description;
        this.hp_bonus = hp_bonus;
        this.attack_bonus = attack_bonus;
        this.magic_bonus = magic_bonus;
    }

    public Path() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHp_bonus() {
        return hp_bonus;
    }

    public void setHp_bonus(double hp_bonus) {
        this.hp_bonus = hp_bonus;
    }

    public double getAttack_bonus() {
        return attack_bonus;
    }

    public void setAttack_bonus(double attack_bonus) {
        this.attack_bonus = attack_bonus;
    }

    public double getMagic_bonus() {
        return magic_bonus;
    }

    public void setMagic_bonus(double magic_bonus) {
        this.magic_bonus = magic_bonus;
    }
}
