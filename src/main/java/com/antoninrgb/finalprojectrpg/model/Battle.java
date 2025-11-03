package com.antoninrgb.finalprojectrpg.model;
import jakarta.persistence.*;

@Entity
public class Battle {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Avatar avatar;

    @ManyToOne
    private Enemy enemy;

    private boolean playerWon;

    /* Constructors, getters, setters */
    public Battle(Avatar avatar, boolean playerWon, Enemy enemy) {
        this.avatar = avatar;
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

    public Avatar getPlayer() {
        return avatar;
    }

    public void setPlayer(Avatar avatar) {
        this.avatar = avatar;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
