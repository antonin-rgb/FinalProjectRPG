package com.antoninrgb.finalprojectrpg.model;
import com.antoninrgb.finalprojectrpg.enums.EnemyType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Enemy {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private EnemyType enemyType;

    private double hp;

    private double attack;

    private double magic;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "dominion_id")
    private Dominion dominion;

    /* Constructors, getters, setters */
    public Enemy(String name, String description, EnemyType enemyType, double hp, double attack, double magic, Dominion dominion) {
        this.name = name;
        this.description = description;
        this.enemyType = enemyType;
        this.hp = hp;
        this.attack = attack;
        this.magic = magic;
        this.dominion = dominion;
    }

    public Enemy() {
    }

    public Enemy(String name, String description, EnemyType enemyType, double hp, double attack, double magic) {
        this.name = name;
        this.description = description;
        this.enemyType = enemyType;
        this.hp = hp;
        this.attack = attack;
        this.magic = magic;
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

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(EnemyType enemyType) {
        this.enemyType = enemyType;
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

    public Dominion getDominion() {
        return dominion;
    }

    public void setDominion(Dominion dominion) {
        this.dominion = dominion;
    }
}
