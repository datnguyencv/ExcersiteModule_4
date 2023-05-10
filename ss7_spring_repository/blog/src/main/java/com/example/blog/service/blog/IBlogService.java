package com.example.blog.service.blog;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService {
    void createBlog(Blog blog);

    void updateBlog(Blog blog);

    Optional<Blog> findById(Integer id);

    void removeById(Integer id);

    Page<Blog> findAll(String nameSearch, Pageable pageable);

    Page<Blog> findCategory(Integer id, Pageable pageable);


}
