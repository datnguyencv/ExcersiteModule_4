package com.example.productmanagement.service.impl;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.repository.IProductRepository;
import com.example.productmanagement.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository smartphoneRepository;
    @Override
    public List<Product> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public boolean save(Product product) {
        return smartphoneRepository.save(product);
    }

    @Override
    public boolean update(Product product) {
        return smartphoneRepository.update(product);
    }

    @Override
    public boolean remove(int id) {
       return smartphoneRepository.remove(id);
    }

    @Override
    public Product findById(int id) {
        return smartphoneRepository.findById(id);
    }

    @Override
    public List<Product> search(String name) {
        return smartphoneRepository.search(name);
    }
}
