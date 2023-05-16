package com.example.cinemamanagement.controller;

import com.example.cinemamanagement.dto.ShowTimesDTO;
import com.example.cinemamanagement.model.Showtimes;
import com.example.cinemamanagement.service.IMovieService;
import com.example.cinemamanagement.service.IShowTimesService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShowTimesController {
    @Autowired
    private IShowTimesService showTimesService;

    @Autowired
    private IMovieService movieService;

    @GetMapping("/")
    public String Showtimes(Model model){
        model.addAttribute("movie", movieService.findAll());
        model.addAttribute("Showtimes", showTimesService.findAll());
        model.addAttribute("showTimesDTO", new ShowTimesDTO());
        return "/list";
    }

    @GetMapping("/delete")
    public String Delete(@RequestParam("codeDelete") String code){
        this.showTimesService.delete(code);
        return "redirect:/";
    }
    @PostMapping("/create")
    public String Create(@Validated @ModelAttribute ShowTimesDTO showTimesDTO, BindingResult bindingResult, Model model){

        new ShowTimesDTO().validate(showTimesDTO, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("movie", movieService.findAll());
            model.addAttribute("hasError", "true");
            model.addAttribute("showTimesDTO", showTimesDTO);
        }
        Showtimes show = new Showtimes();
        BeanUtils.copyProperties(showTimesDTO,show);
        showTimesService.create(show) ;
        return "/list";
    }




}
