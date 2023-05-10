package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findByTitleContains(String nameSearch, Pageable pageable);

    Page<Blog> findByCategory_Id(Integer id, Pageable pageable);
}
