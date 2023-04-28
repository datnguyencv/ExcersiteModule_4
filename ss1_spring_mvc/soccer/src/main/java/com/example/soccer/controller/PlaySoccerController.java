package com.example.soccer.controller;

import com.example.soccer.service.IPlaySoccerService;
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
        model.addAttribute("playList", this.playSoccerService.findAll());
        model.addAttribute("msg", "Hello World");
        return "home";
    }
}