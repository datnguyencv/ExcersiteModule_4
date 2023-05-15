package com.example.clothingshop.repository;

import com.example.clothingshop.model.Category;
import com.example.clothingshop.model.ClothingShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
