package com.example.soccer.controller;

import com.example.soccer.service.IPlaySoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/delete")
    private void delete(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        this.playSoccerService.removePlayer(id);
            redirectAttributes.addFlashAttribute("message", "Delete Success");
    }

    @GetMapping("/details")
    private String showDetails(@RequestParam("id") Integer id){
        this.playSoccerService.findById(id);
        return "home";
    }
}