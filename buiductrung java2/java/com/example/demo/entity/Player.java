package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlayerId")
    private Long playerId;

    @Column(name = "NationalId")
    private Long nationalId;

    @Column(name = "PlayerName", length = 100)
    private String playerName;

    @Column(name = "HighScore")
    private Integer highScore;

    @Column(name = "Level")
    private Integer level;

    // Getter & Setter
    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getNationalId() {
        return nationalId;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getHighScore() {
        return highScore;
    }

    public void setHighScore(Integer highScore) {
        this.highScore = highScore;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", highScore=" + highScore +
                ", level=" + level +
                '}';
    }
}
