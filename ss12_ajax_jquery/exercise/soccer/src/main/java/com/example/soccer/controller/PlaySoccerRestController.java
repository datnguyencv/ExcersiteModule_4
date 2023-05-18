package com.example.soccer.controller;

import com.example.soccer.dto.SoccerPlayerDTO;
import com.example.soccer.model.SoccerPlayer;
import com.example.soccer.service.IPlaySoccerService;
import com.example.soccer.service.ITeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/api/soccer")
@CrossOrigin("*")
public class PlaySoccerRestController {
    @Autowired
    private IPlaySoccerService playSoccerService;
    @Autowired
    private ITeamService teamService;

    @GetMapping()
    public ResponseEntity<?> getList(Model model,
                                     @RequestParam(required = false, defaultValue = "") String search,
                                     @RequestParam(required = false) @DateTimeFormat(
                                             pattern = "yyyy-MM-dd") LocalDate fromDate,
                                     @RequestParam(required = false) @DateTimeFormat(
                                             pattern = "yyyy-MM-dd") LocalDate toDate,
                                     @RequestParam(required = false) Integer size,
                                     Pageable pageable) {

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
        model.addAttribute("soccerPlayerDTO", new SoccerPlayerDTO());
        return new ResponseEntity<>(soccerPlayerPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<SoccerPlayer>> getViewPage(@PathVariable("id") Integer id) {
        Optional<SoccerPlayer> soccerPlayer = playSoccerService.findById(id);
        if (!soccerPlayer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(soccerPlayer, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createPlayer(@Validated @RequestBody SoccerPlayerDTO soccerPlayerDTO,
                                          BindingResult bindingResult,
                                          RedirectAttributes redirectAttributes, Model model) {
        model.addAttribute("soccerPlayerDTO", new SoccerPlayerDTO());
        if (bindingResult.hasErrors()) {
            model.addAttribute("hashError", "true");
            model.addAttribute("soccerPlayerDTO", soccerPlayerDTO);
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        } else {
            SoccerPlayer player = new SoccerPlayer();
            BeanUtils.copyProperties(soccerPlayerDTO, player);
            playSoccerService.create(player);
            redirectAttributes.addFlashAttribute("message", "Create Success");
        }
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> updatePlayer(@Validated @ModelAttribute SoccerPlayerDTO soccerPlayerDTO,
                                          BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("hashError", "true");
            model.addAttribute("soccerPlayerDTO", soccerPlayerDTO);
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        } else {
            SoccerPlayer player = new SoccerPlayer();
            BeanUtils.copyProperties(soccerPlayerDTO, player);
            this.playSoccerService.update(player);
            redirectAttributes.addFlashAttribute("message","Update Success");
        }
        return new ResponseEntity<>(model, HttpStatus.OK);
    }


}
