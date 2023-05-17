package com.example.soccer.controller;

import com.example.soccer.dto.SoccerPlayerDTO;
import com.example.soccer.exception.ExceptionHandle;
import com.example.soccer.model.SoccerPlayer;
import com.example.soccer.service.IPlaySoccerService;
import com.example.soccer.service.ITeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                           @RequestParam(required = false) Integer size,
                           Pageable pageable
    ) throws ExceptionHandle {
        List<SoccerPlayer> soccerPlayerList = playSoccerService.findAllByStatusIsTrue();
        if (soccerPlayerList.size() > 11) {
            throw new ExceptionHandle();
        }

        int pageSize = pageable.getPageSize();
        if (size != null && size > 0) {
            pageSize = size;
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
        model.addAttribute("soccerPlayerNew", new SoccerPlayerDTO());
        model.addAttribute("numberRegistered", soccerPlayerList.size());
        return "home";
    }

    @GetMapping("/teams")
    public String getTeams(Model model) {
        model.addAttribute("teams", teamService.findAll());
        return "home";
    }

    @PostMapping("/delete")
    private String delete(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        this.playSoccerService.removePlayer(id);
        redirectAttributes.addFlashAttribute("message", "Delete Success");
        return "redirect:/";
    }

    @GetMapping("/details")
    private String showDetails(@RequestParam("id") Integer id) {
        this.playSoccerService.findById(id);
        return "home";
    }

    @PostMapping("/create")
    public String createSoccerPlayer(@Validated @ModelAttribute SoccerPlayerDTO soccerPlayerDTO,
                                     BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("hasErrors", "true");
            model.addAttribute("soccerPlayerNew", soccerPlayerDTO);
        } else {
            SoccerPlayer player = new SoccerPlayer();
            BeanUtils.copyProperties(soccerPlayerDTO, player);
            playSoccerService.create(player);
            redirectAttributes.addFlashAttribute("message", "Create success");
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateSoccerPlayer(@PathVariable("id") int id, Model model) {
        SoccerPlayer player = this.playSoccerService.findById(id).orElse(null);
        SoccerPlayerDTO soccerPlayerDTO = new SoccerPlayerDTO();
        assert player != null;
        BeanUtils.copyProperties(player, soccerPlayerDTO);
        model.addAttribute("soccerPlayerDTO", soccerPlayerDTO);
        model.addAttribute("teams", teamService.findAll());
        return "/update";
    }

    @PostMapping("/update")
    public String updateSoccerPlayer(@ModelAttribute @Validated SoccerPlayerDTO soccerPlayerDTO,
                                     BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("soccerPlayerDTO", soccerPlayerDTO);
            model.addAttribute("teams", teamService.findAll());
            return "update";
        } else {
            SoccerPlayer player = new SoccerPlayer();
            BeanUtils.copyProperties(soccerPlayerDTO, player);
            playSoccerService.update(player);
            redirectAttributes.addFlashAttribute("message", "Update Success");
        }
        return "redirect:/";
    }

    @ExceptionHandler(ExceptionHandle.class)
    public String showException() {
        return "errorPage";
    }
}
