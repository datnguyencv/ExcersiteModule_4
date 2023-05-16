package com.example.soccer.repository;

import com.example.soccer.model.Teams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamsRepository extends JpaRepository<Teams, Integer> {
}
