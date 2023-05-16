package com.example.controller;

import com.example.dto.FavoriteDto;
import com.example.dto.SoccerDto;
import com.example.model.Soccer;
import com.example.service.ISoccerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("favorite")
public class SoccerController {
    @Autowired
    private ISoccerService soccerService;

    @ModelAttribute("favorite")
    public FavoriteDto initFavorite() {
        return new FavoriteDto();
    }

    @GetMapping("")
    public String showList(Model model, @CookieValue(value = "soccerId",required = false,defaultValue = "-1") int id) {
        model.addAttribute("soccerList", soccerService.findAll());
        return "soccer/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("soccer", soccerService.findById(id));
        return "soccer/detail";
    }

    @GetMapping("add/{id}")
    public String addFavorite(@PathVariable int id, @SessionAttribute("favorite") FavoriteDto favoriteDto,
                              HttpServletResponse response) {

        int num=response.getStatus();
        for (Soccer soccers:soccerService.findAll()) {
            if (soccerService.findById(id).isPresent()){
                soccers.setStatus(soccers.getStatus()+1);
            }
        }

        Soccer soccer = soccerService.findById(id).get();
        SoccerDto soccerDto = new SoccerDto();
        BeanUtils.copyProperties(soccer, soccerDto);
        favoriteDto.addFavoriteSoccer(soccerDto);


        Cookie cookie = new Cookie("soccerId", id + "");
        cookie.setMaxAge(1 * 24 * 60 * 60);
        cookie.setPath("/favorite");
        response.addCookie(cookie);

        return "redirect:/favorite";
    }
}
