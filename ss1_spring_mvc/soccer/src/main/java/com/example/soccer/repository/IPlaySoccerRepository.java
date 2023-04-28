package com.example.soccer.repository;

import com.example.soccer.model.SoccerPlayer;

import java.util.List;

public interface IPlaySoccerRepository {
    List<SoccerPlayer> findAll();

    SoccerPlayer removePlayer(String playerId);

    List<SoccerPlayer> findById(String playerId);
}
