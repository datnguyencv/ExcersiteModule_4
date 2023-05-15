package com.example.clothingshop.controller;

import com.example.clothingshop.service.ICategoryService;
import com.example.clothingshop.service.IClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClothingShopController {
    @Autowired
    private IClothingService clothingService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String gelAll(Model model) {
        model.addAttribute("clothe", this.clothingService.getClothing());
        return "/list";

    }
}
