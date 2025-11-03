package com.antoninrgb.finalprojectrpg.model;
import com.antoninrgb.finalprojectrpg.enums.SpecialtyType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Specialty {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private SpecialtyType type;

    private double value;

    /* Constructors, getters, setters */
    public Specialty(String name, SpecialtyType type, double value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public Specialty() {
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

    public SpecialtyType getType() {
        return type;
    }

    public void setType(SpecialtyType type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
