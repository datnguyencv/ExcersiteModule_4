package com.example.soccer.controller;

import com.example.soccer.model.SoccerPlayer;
import com.example.soccer.service.IPlaySoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PlaySoccerController {
    @Autowired
    private IPlaySoccerService playSoccerService;

    @GetMapping("/")
    private String showAll(@RequestParam(name ="search",defaultValue = "") String name, Model model) {
        model.addAttribute("playList", this.playSoccerService.findAll());
        model.addAttribute("playList", this.playSoccerService.findAllByName(name));
        model.addAttribute("player", new SoccerPlayer());

        return "home";
    }

    @PostMapping("/delete")
    private void delete(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        if (this.playSoccerService.removePlayer(id)){
            redirectAttributes.addFlashAttribute("message", "Delete Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Do Not Delete. Not Found");
        }
    }

    @GetMapping("/details")
    private String showDetails(@RequestParam("id") Integer id){
        this.playSoccerService.findById(id);
        return "home";
    }

    @GetMapping("/create")
    public String showCreateSoccerPlayer(Model model) {
        model.addAttribute("soccerPlayer", new SoccerPlayer());
        return "/create";
    }

    @PostMapping("/create")
    public String createSoccerPlayer(@ModelAttribute SoccerPlayer soccerPlayer) {
        playSoccerService.create(soccerPlayer);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showUpdateSoccerPlayer(@PathVariable("id") int id, Model model) {
        model.addAttribute("soccerPlayer", playSoccerService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String updateSoccerPlayer(@ModelAttribute SoccerPlayer soccerPlayer) {
        playSoccerService.update(soccerPlayer);
        return "redirect:/";
    }
    
}