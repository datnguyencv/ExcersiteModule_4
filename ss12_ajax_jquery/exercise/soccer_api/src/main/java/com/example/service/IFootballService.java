package com.example.service;

import com.example.model.PlayerSoccer;

import java.util.List;

public interface IFootballService {
    List<PlayerSoccer> findAll();

    void save(PlayerSoccer playerSoccer);

    PlayerSoccer findById(int id);
}
