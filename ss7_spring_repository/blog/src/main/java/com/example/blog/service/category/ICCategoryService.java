package com.example.blog.service.category;

import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICCategoryService {
    void createCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Integer id);

    Optional<Category> findById(Integer id);

    List<Category> findALLCategory();

    Page<Category> findAll(String nameSearch, Pageable pageable);
}
