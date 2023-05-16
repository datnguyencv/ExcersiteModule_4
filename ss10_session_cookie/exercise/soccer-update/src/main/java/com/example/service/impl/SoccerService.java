package com.example.service.impl;


import com.example.model.Soccer;
import com.example.repository.ISoccerRepository;
import com.example.service.ISoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoccerService implements ISoccerService {
    @Autowired
    private ISoccerRepository iSoccerRepository;


    @Override
    public List<Soccer> findAll() {
        return iSoccerRepository.findAll();
    }

    @Override
    public Optional<Soccer> findById(int id) {
        return iSoccerRepository.findById(id);
    }
}
