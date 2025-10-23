package com.antoninrgb.finalprojectrpg.model;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Inventory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Weapon weapon;

    @ManyToMany
    @JoinTable(
            name = "equipped_scrolls",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "scroll_id")
    )
    private List<Scroll> scroll = new ArrayList<>();

    private double gold;

    /* Constructors, getters, setters */
    public Inventory(Weapon weapon, List<Scroll> scroll, double gold) {
        this.weapon = weapon;
        this.scroll = scroll;
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

    public List<Scroll> getScroll() {
        return scroll;
    }

    public void setScroll(List<Scroll> scroll) {
        this.scroll = scroll;
    }

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }
}
