package com.antoninrgb.finalprojectrpg.model;
import jakarta.persistence.*;

@Entity
public class Battle {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    private Enemy enemy;

    private boolean playerWon;

    /* Constructors, getters, setters */
    public Battle(Player player, boolean playerWon, Enemy enemy) {
        this.player = player;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
