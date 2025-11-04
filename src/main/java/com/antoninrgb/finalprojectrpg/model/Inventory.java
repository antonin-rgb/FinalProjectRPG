package com.antoninrgb.finalprojectrpg.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Inventory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @ManyToOne
    private Weapon weapon;

    private double gold;

    /* Constructors, getters, setters */
    public Inventory(Weapon weapon, double gold) {
        this.weapon = weapon;
        this.gold = gold;
    }

    public Inventory() {
    }

    public Inventory(double gold) {
        this.gold = gold;
    }

    public int getId() {
        return id;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }
}
