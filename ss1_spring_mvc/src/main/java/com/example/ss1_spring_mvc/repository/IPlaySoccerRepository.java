package com.example.ss1_spring_mvc.repository;

import com.example.ss1_spring_mvc.model.SoccerPlayer;

import java.util.List;

public interface IPlaySoccerRepository {
    List<SoccerPlayer> findAll();
}
