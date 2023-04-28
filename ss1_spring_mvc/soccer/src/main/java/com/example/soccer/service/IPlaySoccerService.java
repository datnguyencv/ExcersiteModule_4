package com.example.soccer.service;

import com.example.soccer.model.SoccerPlayer;

import java.util.List;

public interface IPlaySoccerService {
    List<SoccerPlayer> findAll();

    SoccerPlayer removePlayer(String playerId);

    List<SoccerPlayer> findById(String playerId);
}
