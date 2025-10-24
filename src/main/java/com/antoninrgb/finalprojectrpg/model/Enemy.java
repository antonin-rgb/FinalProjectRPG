package com.antoninrgb.finalprojectrpg.model;
import com.antoninrgb.finalprojectrpg.enums.EnemyType;
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

    @ManyToOne
    private Specialty specialty;

    private double attack;

    private double magic;

    @ManyToOne
    private Dominion dominion;

    /* Constructors, getters, setters */
    public Enemy(String name, String description, EnemyType enemyType, double hp, Specialty specialty, double attack, double magic, Dominion dominion) {
        this.name = name;
        this.description = description;
        this.enemyType = enemyType;
        this.hp = hp;
        this.specialty = specialty;
        this.attack = attack;
        this.magic = magic;
        this.dominion = dominion;
    }

    public Enemy() {
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

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
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
