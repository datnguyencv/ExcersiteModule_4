package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.blog.IBlogService;
import com.example.blog.service.category.ICCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICCategoryService categoryService;

    @GetMapping("")
    public String showBlog(Model model,
                           @RequestParam(required = false, defaultValue = "")
                           @PageableDefault(sort = "localDate", direction = Sort.Direction.ASC) String nameSearch, Pageable pageable) {
        model.addAttribute("blogSet", blogService.findAll(nameSearch, pageable));
        model.addAttribute("nameSearch", nameSearch);
        return "/blog/index";
    }

    @GetMapping("/list-blog")
    String blogList(Model model,
                    @RequestParam(required = false, defaultValue = "")String nameSearch,
                    @PageableDefault(size = 5, page = 0, sort = "localDate", direction = Sort.Direction.ASC)
                     Pageable pageable) {
        Page<Blog>  blogSet = blogService.findAll(nameSearch.trim(), pageable);
        model.addAttribute("blogSet", blogSet);
        model.addAttribute("blogNew", new Blog());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("categories", categoryService.findALLCategory());
        return "/blog/list";
    }

    @GetMapping("/list-blog-by-category")
    String findByCategoryBlog(Model model,
                              @RequestParam(required = false, defaultValue = "")
                              Integer idSearch, Pageable pageable) {
        model.addAttribute("blogSet", blogService.findCategory(idSearch, pageable));
        model.addAttribute("blogNew", new Blog());
        model.addAttribute("idSearch", idSearch);
        model.addAttribute("categories", categoryService.findALLCategory());
        return "/blog/list";
    }

    @GetMapping("/edit-blog/{id}")
    public String editBlog(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categories", categoryService.findALLCategory());
        return "/blog/edit";
    }

    @GetMapping("/view-blog/{id}")
    public String getViewPage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categories", categoryService.findALLCategory());
        return "/blog/view";
    }

    @PostMapping("/update-blog")
    public String updateBlog(@ModelAttribute("blog") Blog blog, Model model) {
        blogService.updateBlog(blog);
        model.addAttribute("message", "Update successful!");
        return "/blog/edit";
    }

    @PostMapping("/create-blog")
    public String saveBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.createBlog(blog);
        redirectAttributes.addFlashAttribute("mess", "Add new successful!");
        return "redirect:/list-blog";
    }

}
