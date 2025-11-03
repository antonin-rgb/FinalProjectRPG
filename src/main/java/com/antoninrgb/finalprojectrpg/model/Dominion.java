package com.antoninrgb.finalprojectrpg.model;
import com.antoninrgb.finalprojectrpg.enums.Element;
import jakarta.persistence.*;

@Entity
public class Dominion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Element element;

    @ManyToOne
    private Specialty specialty;

    /* Constructors, getters, setters */
    public Dominion(String name, String description, Element element, Specialty specialty) {
        this.name = name;
        this.description = description;
        this.element = element;
        this.specialty = specialty;
    }

    public Dominion() {
    }

    public Dominion(String name, String description, Element element) {
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

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
}
