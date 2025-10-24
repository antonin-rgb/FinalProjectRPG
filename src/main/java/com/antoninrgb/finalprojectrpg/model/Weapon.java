package com.antoninrgb.finalprojectrpg.model;
import com.antoninrgb.finalprojectrpg.enums.Element;
import jakarta.persistence.*;

@Entity
public class Weapon {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Element element;

    private double attack;

    private double magic;

    private double crit;

    private double price;

    /* Constructors, getters, setters */
    public Weapon(String name, String description, Element element, double attack, double magic, double crit, double price) {
        this.name = name;
        this.description = description;
        this.element = element;
        this.attack = attack;
        this.magic = magic;
        this.crit = crit;
        this.price = price;
    }

    public Weapon() {
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

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getMagic() {
        return magic;
    }

    public void setMagic(double magic) {
        this.magic = magic;
    }

    public double getCrit() {
        return crit;
    }

    public void setCrit(double crit) {
        this.crit = crit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
