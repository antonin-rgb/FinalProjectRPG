package com.antoninrgb.finalprojectrpg.model;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Virtue {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "virtue_specialties",
            joinColumns = @JoinColumn(name = "virtue_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id")
    )
    private List<Specialty> specialties = new ArrayList<>();

    /* Constructors, getters, setters */
    public Virtue(String name, String description, List<Specialty> specialties) {
        this.name = name;
        this.description = description;
        this.specialties = specialties;
    }

    public Virtue() {
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

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialty(List<Specialty> specialties) {
        this.specialties = specialties;
    }
}