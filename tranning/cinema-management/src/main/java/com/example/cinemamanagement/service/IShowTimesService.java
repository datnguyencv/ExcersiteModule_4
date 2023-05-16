package com.example.cinemamanagement.service;

import com.example.cinemamanagement.model.Showtimes;

import java.util.List;

public interface IShowTimesService {
    List<Showtimes> findAll();

    Showtimes create(Showtimes showtimes);

    void delete(String code);
}