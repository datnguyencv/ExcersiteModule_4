package com.example.ss1_spring_mvc.service.impl;

import com.example.ss1_spring_mvc.model.SoccerPlayer;
import com.example.ss1_spring_mvc.repository.IPlaySoccerRepository;
import com.example.ss1_spring_mvc.service.IPlaySoccerService;
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
}
