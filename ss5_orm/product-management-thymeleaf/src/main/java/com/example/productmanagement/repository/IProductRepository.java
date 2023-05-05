package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    boolean save(Product Product);

    boolean update(Product Product);

    boolean remove(int id);

    Product findById(int id);

    List<Product> search(String name);
}
