package com.example.soccer.repository;

import com.example.soccer.model.SoccerPlayer;

import java.util.List;

public interface IPlaySoccerRepository {
    List<SoccerPlayer> findAllByName(String name);

    List<SoccerPlayer> findAll();
    boolean removePlayer(Integer id);

    SoccerPlayer findById(Integer id);

    void create(SoccerPlayer soccerPlayer);

    void update(SoccerPlayer soccerPlayer);
}
