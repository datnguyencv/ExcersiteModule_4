package com.example.cinemamanagement.repository;

import com.example.cinemamanagement.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
}
