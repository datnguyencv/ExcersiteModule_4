package com.example.cinemamanagement.service.impl;

import com.example.cinemamanagement.model.Showtimes;
import com.example.cinemamanagement.repository.IShowTimesRepository;
import com.example.cinemamanagement.service.IShowTimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTimesService implements IShowTimesService {

    @Autowired
    private IShowTimesRepository showTimesRepository;

    @Override
    public List<Showtimes> findAll() {
        return showTimesRepository.findAll();
    }

    @Override
    public Showtimes create(Showtimes showtimes) {
        return showTimesRepository.save(showtimes);
    }

    @Override
    public void delete(String code) {
        showTimesRepository.deleteByCode(code);
    }
}