package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void update(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        this.blogRepository.deleteById(id);
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return this.blogRepository.findById(id);
    }

    @Override
    public List<Blog> findByName(String name) {
        return null;
    }

}
