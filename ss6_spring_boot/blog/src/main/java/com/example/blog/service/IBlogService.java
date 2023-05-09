package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IBlogService {

    List<Blog> findAll();

    void update(Blog blog);

    void save(Blog blog);

    void remove(Integer id);

    Optional<Blog> findById(Integer id);

    List<Blog> findByName(String name);


}
