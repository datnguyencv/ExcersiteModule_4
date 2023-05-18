package com.example.service.impl;


import com.example.model.PlayerSoccer;
import com.example.repository.IFootballRepository;
import com.example.service.IFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballService implements IFootballService {
    @Autowired
    private IFootballRepository iFootballRepository;

    @Override
    public List<PlayerSoccer> findAll() {
        return iFootballRepository.findAll();
    }

    @Override
    public void save(PlayerSoccer playerSoccer) {
        iFootballRepository.save(playerSoccer);
    }

    @Override
    public PlayerSoccer findById(int id) {
        return iFootballRepository.getById(id);
    }
}
