package com.example.clothingshop.service.impl;

import com.example.clothingshop.model.Category;
import com.example.clothingshop.repository.ICategoryRepository;
import com.example.clothingshop.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> getClothing() {
        return categoryRepository.findAll();
    }

}
