package com.example.clothingshop.repository;

import com.example.clothingshop.model.ClothingShop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClothingRepository extends JpaRepository<ClothingShop, Integer> {

    List<ClothingShop> findAllByActiveFalse();
}
