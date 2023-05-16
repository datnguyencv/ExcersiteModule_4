package com.example.service;

import com.example.model.Soccer;

import java.util.List;
import java.util.Optional;

public interface ISoccerService {
    List<Soccer> findAll();

    Optional<Soccer> findById(int id);
}
