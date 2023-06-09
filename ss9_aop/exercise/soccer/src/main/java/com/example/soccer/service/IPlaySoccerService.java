package com.example.soccer.service;

import com.example.soccer.model.SoccerPlayer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IPlaySoccerService {
    Page<SoccerPlayer> findAllByNameAndDateOfBirth(String search, String fromDate, String tDate, Pageable pageable);

    Page<SoccerPlayer> findAllByName(String search, Pageable pageable);

    void create(SoccerPlayer soccerPlayer);

    void update(SoccerPlayer soccerPlayer);

    void removePlayer(Integer id);

    Optional<SoccerPlayer> findById(Integer id);

    List<SoccerPlayer> findAll();
    List<SoccerPlayer> findAllByStatusIsTrue();
}
