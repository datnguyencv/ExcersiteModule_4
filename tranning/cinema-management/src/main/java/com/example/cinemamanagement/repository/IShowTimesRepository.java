package com.example.cinemamanagement.repository;

import com.example.cinemamanagement.model.Showtimes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShowTimesRepository extends JpaRepository<Showtimes, Integer> {
    void deleteByCode(String code);
}
