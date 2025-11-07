package com.antoninrgb.finalprojectrpg.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Dominion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @ManyToOne
    private Specialty specialty;

    @OneToMany(mappedBy = "dominion")
    @JsonIgnore
    private List<Enemy> enemies;

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

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }
}
