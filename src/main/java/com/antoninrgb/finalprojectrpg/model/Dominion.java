package com.antoninrgb.finalprojectrpg.model;
import com.antoninrgb.finalprojectrpg.enums.Element;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Dominion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Element element;

    @ManyToMany
    @JoinTable(
            name = "dominion_specialties",
            joinColumns = @JoinColumn(name = "dominion_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id")
    )
    private List<Specialty> specialties = new ArrayList<>();

    /* Constructors, getters, setters */
    public Dominion(List<Specialty> specialties, Element element, String description, String name) {
        this.specialties = specialties;
        this.element = element;
        this.description = description;
        this.name = name;
    }

    public Dominion() {
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

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }
}
