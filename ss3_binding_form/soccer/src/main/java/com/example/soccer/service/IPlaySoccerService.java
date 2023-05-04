package com.example.soccer.service;

import com.example.soccer.model.SoccerPlayer;

import java.util.List;

public interface IPlaySoccerService {
    List<SoccerPlayer> findAll();

    boolean removePlayer(Integer id);

    SoccerPlayer findById(Integer id);

    boolean createPlayer(SoccerPlayer player);

    boolean updatePlayer(SoccerPlayer player);
}
