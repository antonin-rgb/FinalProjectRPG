package com.antoninrgb.finalprojectrpg.model;
import jakarta.persistence.*;

@Entity
public class Scroll {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @OneToOne
    private Specialty specialty;

    private double price;

    /* Constructors, getters, setters */
    public Scroll(String name, String description, Specialty specialty, double price) {
        this.name = name;
        this.description = description;
        this.specialty = specialty;
        this.price = price;
    }

    public Scroll() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
