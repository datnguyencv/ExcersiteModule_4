package com.example.blog.service.blog.impl;

import com.example.blog.model.Blog;
import com.example.blog.repository.blog.IBlogRepository;
import com.example.blog.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(String nameSearch, Pageable pageable) {
        return blogRepository.findByTitleContaining(nameSearch, pageable);
    }

    @Override
    public Page<Blog> findByCategory(Long id, Pageable pageable) {
        return blogRepository.findByCategory_Id(id, pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void removeById(Long id) {
        blogRepository.deleteById(id);
    }
}
