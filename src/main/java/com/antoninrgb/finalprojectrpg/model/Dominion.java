package com.antoninrgb.finalprojectrpg.model;
import jakarta.persistence.*;

@Entity
public class Dominion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @ManyToOne
    private Specialty specialty;

    /* Constructors, getters, setters */
    public Dominion(String name, String description, Specialty specialty) {
        this.name = name;
        this.description = description;
        this.specialty = specialty;
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
}
