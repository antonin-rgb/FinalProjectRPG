package com.antoninrgb.finalprojectrpg.model;
import com.antoninrgb.finalprojectrpg.enums.SpecialtyType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Specialty {

    @Getter @Id @GeneratedValue (strategy = GenerationType.IDENTITY) private int id;
    @Getter @Setter private String name;
    @Getter @Setter @Enumerated(EnumType.STRING) private SpecialtyType type;
    @Getter @Setter private double value;

    /* Constructors, getters, setters */
    public Specialty(String name, SpecialtyType type, double value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public Specialty() {
    }

}
