package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.category.ICCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    @Autowired
    ICCategoryService categoryService;

    @GetMapping("/list-category")
    public String findAllCategory(Model model, @RequestParam(required = false, defaultValue = "") String nameSearch,
                                  @PageableDefault(page = 0, size = 5) Pageable pageable) {
        model.addAttribute("categories", categoryService.findAll(nameSearch.trim(), pageable));
        model.addAttribute("category", new Category());
        model.addAttribute("nameSearch", nameSearch);
        return "/category/list";
    }

    @PostMapping("/create-category")
    public String saveCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.createCategory(category);
        redirectAttributes.addFlashAttribute("mess", "Add new successful!");
        return "redirect:/list-category";
    }

    @GetMapping("/edit-category/{id}")
    public String editCategory(Model model, @PathVariable Integer id) {
        model.addAttribute("category", categoryService.findById(id));
        return "/category/edit";
    }

    @PostMapping("/update-category")
    public String updateCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.updateCategory(category);
        redirectAttributes.addFlashAttribute("mess","Update successful!");
        return "/category/edit";
    }

    @GetMapping("/delete-category")
    public String deleteBlog(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        categoryService.deleteCategory(id);
        redirectAttributes.addFlashAttribute("mess", "Delete successful!");
        return "redirect:/list-category";
    }
}
