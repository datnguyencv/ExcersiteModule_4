package com.example.song.service;

import com.example.song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);

    Optional<Song> findById(Integer id);
    void save(Song song);
    void update(Song song);
}
