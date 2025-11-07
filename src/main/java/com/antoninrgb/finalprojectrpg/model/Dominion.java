package com.antoninrgb.finalprojectrpg.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Dominion {

    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter @ManyToOne private Specialty specialty;
    @Getter @Setter @OneToMany(mappedBy = "dominion") @JsonIgnore private List<Enemy> enemies;

    /* Constructors, getters, setters */
    public Dominion(String name, String description, Specialty specialty, List<Enemy> enemies) {
        this.name = name;
        this.description = description;
        this.specialty = specialty;
        this.enemies = enemies;
    }

    public Dominion() {
    }

    public Dominion(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
