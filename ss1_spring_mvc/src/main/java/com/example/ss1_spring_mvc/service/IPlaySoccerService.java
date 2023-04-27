package com.example.ss1_spring_mvc.service;

import com.example.ss1_spring_mvc.model.SoccerPlayer;

import java.util.List;

public interface IPlaySoccerService {
    List<SoccerPlayer> findAll();
}
