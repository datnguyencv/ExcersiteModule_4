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
    public boolean removePlayer(Integer id) {
        if (this.playerRepository.removePlayer(id)) {
            return true;
        }
        ;
        return false;
    }

    @Override
    public SoccerPlayer findById(Integer id) {
        return this.playerRepository.findById(id);
    }

    @Override
    public boolean createPlayer(SoccerPlayer player) {
        return this.playerRepository.createPlayer(player);
    }

    @Override
    public boolean updatePlayer(SoccerPlayer player) {
        SoccerPlayer player1 =this.playerRepository.findById(player.getId());
        if (player1==null) {
            return false;
        } else {
            return this.playerRepository.updatePlayer(player1);
        }
    }
}