package com.example.clothingshop.service;

import com.example.clothingshop.model.ClothingShop;

import java.util.List;

public interface IClothingService {
    List<ClothingShop> getClothing();

    ClothingShop saveClothing(ClothingShop clothingShop);

    ClothingShop updateClothing(ClothingShop clothingShop);

    void deleteById(Integer id);


}
