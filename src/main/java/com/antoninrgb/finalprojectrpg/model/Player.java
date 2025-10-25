package com.antoninrgb.finalprojectrpg.model;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nickname;

    private double hp = 500;

    private double attack = 20;

    private double magic = 0;

    @ManyToOne
    private Path path;

    @ManyToOne
    private Virtue virtue;

    @OneToOne
    private Inventory inventory;

    @ManyToOne
    private Dominion dominion;

    @OneToMany(mappedBy = "player")
    private List<Battle> battle = new ArrayList<>();

    /* Constructors, getters, setters */
    public Player(String nickname, double hp, double attack, double magic, Path path, Virtue virtue, Inventory inventory, Dominion dominion, List<Battle> battle) {
        this.nickname = nickname;
        this.hp = hp;
        this.attack = attack;
        this.magic = magic;
        this.path = path;
        this.virtue = virtue;
        this.inventory = inventory;
        this.dominion = dominion;
        this.battle = battle;
    }

    public Player() {
    }

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getMagic() {
        return magic;
    }

    public void setMagic(double magic) {
        this.magic = magic;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Virtue getVirtue() {
        return virtue;
    }

    public void setVirtue(Virtue virtue) {
        this.virtue = virtue;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Dominion getDominion() {
        return dominion;
    }

    public void setDominion(Dominion dominion) {
        this.dominion = dominion;
    }

    public List<Battle> getBattle() {
        return battle;
    }

    public void setBattle(List<Battle> battle) {
        this.battle = battle;
    }
}
