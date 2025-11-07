package com.antoninrgb.finalprojectrpg.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Path {

    @Getter @Id @GeneratedValue (strategy = GenerationType.IDENTITY) private int id;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter @JsonIgnore private double hp_bonus;
    @Getter @Setter @JsonIgnore private double attack_bonus;
    @Getter @Setter @JsonIgnore private double magic_bonus;

    /* Constructors, getters, setters */
    public Path(String name, String description, double hp_bonus, double attack_bonus, double magic_bonus) {
        this.name = name;
        this.description = description;
        this.hp_bonus = hp_bonus;
        this.attack_bonus = attack_bonus;
        this.magic_bonus = magic_bonus;
    }

    public Path() {
    }

}
