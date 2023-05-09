package com.example.soccer.controller;

import com.example.soccer.model.SoccerPlayer;
import com.example.soccer.service.IPlaySoccerService;
import com.example.soccer.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class PlaySoccerController {
    @Autowired
    private IPlaySoccerService playSoccerService;
    @Autowired
    private ITeamService teamService;

    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(required = false, defaultValue = "") String search,
                           @RequestParam(required = false) @DateTimeFormat(
                                   pattern = "yyyy-MM-dd") LocalDate fromDate,
                           @RequestParam(required = false) @DateTimeFormat(
                                   pattern = "yyyy-MM-dd") LocalDate toDate,
                           @RequestParam(required = false) Integer pageInput,
                           Pageable pageable
    ) {
        int pageSize = pageable.getPageSize();
        if (pageInput != null && pageInput > 0) {
            pageSize = pageInput;
        }

        Sort sort = search.isEmpty() ? Sort.by("dateOfBirth").ascending() : Sort.by("name").ascending();
        Page<SoccerPlayer> soccerPlayerPage;
        String fromStr = null;
        String toStr = null;
        if (fromDate != null && toDate != null) {
            fromStr = fromDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            toStr = toDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            soccerPlayerPage = playSoccerService.findAllByNameAndDateOfBirth(search, fromStr, toStr, PageRequest.of(
                    pageable.getPageNumber(), pageSize, sort));
        } else {
            soccerPlayerPage = playSoccerService.findAllByName(search, PageRequest.of(pageable.getPageNumber(), pageSize, sort));
        }
        model.addAttribute("soccerPlayerPage", soccerPlayerPage);
        List<Integer> pageNumberList;
        int currentPage = pageable.getPageNumber() + 1;
        int totalRecords = (int) soccerPlayerPage.getTotalElements();

        pageable = PageRequest.of(currentPage - 1, pageSize, sort);
        Page<?> page = new PageImpl<>(Collections.emptyList(), pageable, totalRecords);
        pageNumberList = IntStream.rangeClosed(
                1, page.getTotalPages()).boxed().collect(Collectors.toList());
        model.addAttribute("pageNumberList", pageNumberList);
        model.addAttribute("teams", teamService.findAll());
        model.addAttribute("soccerPlayerNew", new SoccerPlayer());
        return "home";
    }

    @GetMapping("/teams")
    public String getTeams(Model model){
        model.addAttribute("teams", teamService.findAll());
        return "home";
    }

}
