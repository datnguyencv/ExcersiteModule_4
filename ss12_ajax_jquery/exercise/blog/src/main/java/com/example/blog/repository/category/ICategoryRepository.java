package com.example.blog.repository.category;

import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
    Page<Category> findByNameContaining(String nameSearch, Pageable pageable);
}
