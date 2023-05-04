package com.example.soccer.service;

import com.example.soccer.model.SoccerPlayer;

import java.util.List;

public interface IPlaySoccerService {
    List<SoccerPlayer> findAll();

    void removePlayer(Integer id);

    SoccerPlayer findById(Integer id);
}
