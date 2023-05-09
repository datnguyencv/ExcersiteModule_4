package com.example.soccer.repository;

import com.example.soccer.model.SoccerPlayer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaySoccerRepository extends JpaRepository<SoccerPlayer, Integer> {
    Page<SoccerPlayer> findAllByNameContaining(String search, Pageable pageable);
}
