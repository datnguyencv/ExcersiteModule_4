package com.example.clothingshop.service.impl;

import com.example.clothingshop.model.ClothingShop;
import com.example.clothingshop.repository.IClothingRepository;
import com.example.clothingshop.service.IClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothingShopService implements IClothingService {
    @Autowired
    private IClothingRepository clothingRepository;

    @Override
    public List<ClothingShop> getClothing() {
        return clothingRepository.findAllByActiveFalse();
    }

    @Override
    public ClothingShop saveClothing(ClothingShop clothingShop) {
        return clothingRepository.save(clothingShop);
    }

    @Override
    public ClothingShop updateClothing(ClothingShop clothingShop) {
        return clothingRepository.save(clothingShop);
    }

    @Override
    public void deleteById(Integer id) {
        ClothingShop cobraShop = clothingRepository.findById(id).orElse(null);
        assert cobraShop != null;
        cobraShop.setActive(true);
    }
}
