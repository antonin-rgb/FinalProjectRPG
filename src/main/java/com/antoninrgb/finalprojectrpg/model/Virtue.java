package com.antoninrgb.finalprojectrpg.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Virtue {

    @Getter @Id @GeneratedValue (strategy = GenerationType.IDENTITY) private int id;
    @Setter @Getter private String name;
    @Setter @Getter private String description;
    @Setter @Getter @ManyToOne private Specialty specialty;

    /* Constructors, getters, setters */
    public Virtue(String name, String description, Specialty specialty) {
        this.name = name;
        this.description = description;
        this.specialty = specialty;
    }

    public Virtue() {
    }

    public Virtue(String name, String description) {
        this.name = name;
        this.description = description;
    }

}