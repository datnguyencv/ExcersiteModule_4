package com.example.soccer.repository;

import com.example.soccer.model.SoccerPlayer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPlaySoccerRepository extends JpaRepository<SoccerPlayer, Integer> {
    Page<SoccerPlayer> findAllByNameContainingAndDateOfBirthBetween(String search, String fromDate, String toDate, Pageable pageable);

    Page<SoccerPlayer> findByNameContaining(String search, Pageable pageable);

    List<SoccerPlayer> findAllByStatusIsTrue();
}
