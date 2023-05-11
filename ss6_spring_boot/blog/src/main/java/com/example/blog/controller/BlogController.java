package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICatagorysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICatagorysService categoryService;

    @GetMapping("")
    public String showBlogList(Model model){
        model.addAttribute("blogList", blogService.findAll());
        model.addAttribute("categoryList", categoryService.findAll());
        return "index";
    }

    @GetMapping("/list-blog")
    public String listBlog(Model model){
        model.addAttribute("blogList",blogService.findAll());
        model.addAttribute("blog",new Blog());
        model.addAttribute("categoryList", categoryService.findAll() );
        return "/list";
    }

    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable("id") Integer id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categoryList", categoryService.findAll() );
        return "/edit";
    }

    @GetMapping("/view/{id}")
    public String viewBlog(@PathVariable("id") Integer id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categoryList", categoryService.findAll() );
        return "/view";
    }

    @PostMapping("/update")
    public String viewBlog(@ModelAttribute ("blog") Blog blog, Model model){
        blogService.save(blog);
        model.addAttribute("mess", "Update Successfully");
        return "/edit";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute ("blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addAttribute("mess", "Create Successfully");
        return "redirect:/list-blog";
    }

    @GetMapping("/delete")
    public String deleteBlog(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Delete successful!");
        return "redirect:/list-blog";
    }
}
