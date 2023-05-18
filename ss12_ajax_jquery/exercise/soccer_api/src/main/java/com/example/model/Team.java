package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "team")
    @JsonBackReference
    private List<PlayerSoccer> playerSoccerList;

    public Team() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PlayerSoccer> getPlayerSoccerList() {
        return playerSoccerList;
    }

    public void setPlayerSoccerList(List<PlayerSoccer> playerSoccerList) {
        this.playerSoccerList = playerSoccerList;
    }
}
