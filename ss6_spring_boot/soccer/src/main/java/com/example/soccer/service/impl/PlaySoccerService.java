package com.example.soccer.service.impl;

import com.example.soccer.model.SoccerPlayer;
import com.example.soccer.repository.IPlaySoccerRepository;
import com.example.soccer.service.IPlaySoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PlaySoccerService implements IPlaySoccerService {
    @Autowired
    private IPlaySoccerRepository repository;
    @Override
    public Page<SoccerPlayer> findAll(String search, Pageable pageable) throws Exception {
        return repository.findAllByNameContaining(search, pageable);
    }

    @Override
    public SoccerPlayer create(SoccerPlayer soccerPlayer) {
        return repository.save(soccerPlayer);
    }

    @Override
    public SoccerPlayer update(SoccerPlayer soccerPlayer) {
        return repository.save(soccerPlayer);
    }

    @Override
    public void delete(SoccerPlayer soccerPlayer) {
        repository.delete(soccerPlayer);
    }
}
