package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/list-blog")
    public ResponseEntity<Page<Blog>> findAllBlog(
            @RequestParam(required = false, defaultValue = "") String nameSearch,
            @RequestParam(required = false, defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(0, size);
        Page<Blog> blog = blogService.findAll(nameSearch, pageable);
        if (blog.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
