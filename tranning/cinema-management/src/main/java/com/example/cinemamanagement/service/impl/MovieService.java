package com.example.cinemamanagement.service.impl;

import com.example.cinemamanagement.model.Movie;
import com.example.cinemamanagement.repository.IMovieRepository;
import com.example.cinemamanagement.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private IMovieRepository movieRepository;
    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
