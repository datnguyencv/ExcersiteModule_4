package com.example.ss1_spring_mvc.controller;

import com.example.ss1_spring_mvc.service.IPlaySoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlaySoccerController {
    @Autowired
    private IPlaySoccerService playSoccerService;

    @GetMapping("/")
    private String showAll(Model model) {
        model.addAttribute("list", this.playSoccerService.findAll());
        model.addAttribute("msg", "Hello World");
        return "/home";
    }
}
