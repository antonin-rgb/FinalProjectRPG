package com.antoninrgb.finalprojectrpg.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Avatar {

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

    @OneToOne(cascade = CascadeType.ALL)
    private Inventory inventory;

    @ManyToOne
    private Dominion dominion;

    @OneToMany(mappedBy = "avatar")
    private List<Battle> battles = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    /* Constructors, getters, setters */
    public Avatar(String nickname, double hp, double attack, double magic, Path path, Virtue virtue, Inventory inventory, Dominion dominion, List<Battle> battles, User user) {
        this.nickname = nickname;
        this.hp = hp;
        this.attack = attack;
        this.magic = magic;
        this.path = path;
        this.virtue = virtue;
        this.inventory = inventory;
        this.dominion = dominion;
        this.battles = battles;
        this.user = user;
    }

    public Avatar() {
    }

    public Avatar(String nickname) {
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

    public List<Battle> getBattles() {
        return battles;
    }

    public void setBattles(List<Battle> battles) {
        this.battles = battles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
