package com.example.blog.service.impl;

import com.example.blog.model.Category;
import com.example.blog.repository.ICatagorysRepository;
import com.example.blog.service.ICatagorysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatagorysService implements ICatagorysService {
    @Autowired
    private ICatagorysRepository categoryRepository;
    @Override

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
