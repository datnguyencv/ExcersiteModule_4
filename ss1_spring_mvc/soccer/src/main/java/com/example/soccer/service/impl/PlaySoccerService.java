package com.example.soccer.service.impl;

import com.example.soccer.model.SoccerPlayer;
import com.example.soccer.repository.IPlaySoccerRepository;
import com.example.soccer.service.IPlaySoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PlaySoccerService")
public class PlaySoccerService implements IPlaySoccerService {
    @Autowired
    private IPlaySoccerRepository playerRepository;

    @Override
    public List<SoccerPlayer> findAll() {
        return this.playerRepository.findAll();
    }

    @Override
    public SoccerPlayer removePlayer(String playerId) {
        return null;
    }

    @Override
    public List<SoccerPlayer> findById(String playerId) {
        return null;
    }
}
