package com.example.soccer.service;

import com.example.soccer.model.SoccerPlayer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPlaySoccerService {
    Page<SoccerPlayer> findAll(String search, Pageable pageable) throws Exception;
    SoccerPlayer create(SoccerPlayer soccerPlayer);
    SoccerPlayer update(SoccerPlayer soccerPlayer);
    void delete(SoccerPlayer soccerPlayer);


}
