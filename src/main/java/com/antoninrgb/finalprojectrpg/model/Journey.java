package com.antoninrgb.finalprojectrpg.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Journey {

    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    @JsonIgnore @Getter @Setter @ManyToOne @JoinColumn(name = "avatar_id") private Avatar avatar;
    @Setter @Getter @ManyToOne private Dominion dominion;
    @Getter @Setter @ManyToOne private Enemy enemy;
    @JsonIgnore @Getter @Setter private boolean playerWon;
    // @Getter @Setter private int stage; variable to keep the stage of the journey, implement soon

    /* Constructors, getters, setters */
    public Journey(Avatar avatar, Enemy enemy, boolean playerWon) {
        this.avatar = avatar;
        this.enemy = enemy;
        this.playerWon = playerWon;
    }

    public Journey() {
    }

}
