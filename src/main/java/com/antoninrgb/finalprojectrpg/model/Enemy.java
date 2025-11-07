package com.antoninrgb.finalprojectrpg.model;
import com.antoninrgb.finalprojectrpg.enums.EnemyType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Enemy {

    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter @Enumerated(EnumType.STRING) private EnemyType enemyType;
    @Getter @Setter private double hp;
    @Getter @Setter private double damage;
    @Getter @Setter  @JsonIgnore @ManyToOne @JoinColumn(name = "dominion_id") private Dominion dominion;

    /* Constructors, getters, setters */
    public Enemy(String name, String description, EnemyType enemyType, double hp, double damage, Dominion dominion) {
        this.name = name;
        this.description = description;
        this.enemyType = enemyType;
        this.hp = hp;
        this.damage = damage;
        this.dominion = dominion;
    }

    public Enemy() {
    }

    public Enemy(String name, String description, EnemyType enemyType, double hp, double damage) {
        this.name = name;
        this.description = description;
        this.enemyType = enemyType;
        this.hp = hp;
        this.damage = damage;
    }

}
