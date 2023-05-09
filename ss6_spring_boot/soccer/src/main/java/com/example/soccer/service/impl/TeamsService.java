package com.example.soccer.service.impl;

import com.example.soccer.model.Teams;
import com.example.soccer.repository.ITeamsRepository;
import com.example.soccer.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamsService implements ITeamService {
    @Autowired
    private ITeamsRepository teamRepository;
    @Override
    public List<Teams> findAll() {
        return teamRepository.findAll();
    }
}
