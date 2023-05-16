package com.example.repository;

import com.example.model.Soccer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoccerRepository extends JpaRepository<Soccer, Integer> {

}
