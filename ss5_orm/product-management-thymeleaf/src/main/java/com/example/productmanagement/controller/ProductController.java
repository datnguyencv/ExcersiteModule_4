package com.example.productmanagement.controller;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String getHomePage(@RequestParam(value = "name",defaultValue = "") String name, Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("products", productService.search(name));
        model.addAttribute("Product", new Product());
        return "/index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("Product") Product Product,RedirectAttributes attributes) {
        if(productService.save(Product)){
            attributes.addFlashAttribute("mess","Add new Successful!");
        } else {
            attributes.addFlashAttribute("mess","Add new fail!");
        }
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("Product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("Product") Product Product) {
        productService.update(Product);
        model.addAttribute("mess", "Update successful!");
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idDelete") int id, RedirectAttributes attributes) {
        productService.remove(id);
        attributes.addFlashAttribute("mess", "Delete successful!");
        return "redirect:/product";
    }

    @GetMapping("/view/{id}")
    public String getViewPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("Product", productService.findById(id));
        return "/view";
    }
}
