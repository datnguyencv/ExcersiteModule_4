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
    private IPlaySoccerRepository playSoccerRepository;

    @Override
    public Page<SoccerPlayer> findAllByNameAndDateOfBirth(String search, String fromDate, String toDate, Pageable pageable) {
        return playSoccerRepository.findAllByNameContainingAndDateOfBirthBetween(search, fromDate, toDate, pageable);
    }

    @Override
    public Page<SoccerPlayer> findAllByName(String search, Pageable pageable) {
        return playSoccerRepository.findByNameContaining(search, pageable);
    }

    @Override
    public void create(SoccerPlayer soccerPlayer) {
        this.playSoccerRepository.save(soccerPlayer);
    }

    @Override
    public void update(SoccerPlayer soccerPlayer) {
        this.playSoccerRepository.save(soccerPlayer);
    }

    @Override
    public void delete(SoccerPlayer soccerPlayer) {
        this.playSoccerRepository.delete(soccerPlayer);
    }

    @Override
    public SoccerPlayer findById(Integer id) {
        return playSoccerRepository.findById(id).get();
    }
}
