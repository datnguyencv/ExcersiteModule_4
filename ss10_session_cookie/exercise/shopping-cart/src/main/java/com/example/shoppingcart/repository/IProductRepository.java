package com.example.shoppingcart.repository;

import com.example.shoppingcart.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product, Integer> {
}
