package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    boolean save(Product product);

    boolean update(Product product);

    boolean remove(int id);

    Product findById(int id);

    List<Product> search(String name);
}
