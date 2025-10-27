package com.antoninrgb.finalprojectrpg.model;
import jakarta.persistence.*;

@Entity
public class Battle {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Character character;

    @ManyToOne
    private Enemy enemy;

    private boolean playerWon;

    /* Constructors, getters, setters */
    public Battle(Character character, boolean playerWon, Enemy enemy) {
        this.character = character;
        this.playerWon = playerWon;
        this.enemy = enemy;
    }

    public Battle() {
    }

    public int getId() {
        return id;
    }

    public boolean isPlayerWon() {
        return playerWon;
    }

    public void setPlayerWon(boolean playerWon) {
        this.playerWon = playerWon;
    }

    public Character getPlayer() {
        return character;
    }

    public void setPlayer(Character character) {
        this.character = character;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
