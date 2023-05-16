package com.example.cinemamanagement.service;

import com.example.cinemamanagement.model.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> findAll();
}
