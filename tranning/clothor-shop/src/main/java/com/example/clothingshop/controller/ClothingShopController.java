package com.example.clothingshop.controller;

import com.example.clothingshop.service.ICategoryService;
import com.example.clothingshop.service.IClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/delete")
    public String delete(@RequestParam Integer idDelete, RedirectAttributes redirectAttributes) {
        this.clothingService.deleteById(idDelete);
        redirectAttributes.addFlashAttribute("message", "Clothing was successfully deleted");
        return "redirect:/";
    }

}
