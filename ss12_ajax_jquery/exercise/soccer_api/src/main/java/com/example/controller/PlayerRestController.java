package com.example.controller;

import com.example.model.PlayerSoccer;
import com.example.model.Team;
import com.example.service.IFootballService;
import com.example.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/soccer")
public class PlayerRestController {
    @Autowired
    private IFootballService playerSoccerService;
    @Autowired
    private ITeamService teamService;

    @GetMapping("")
    public ResponseEntity<List<PlayerSoccer>> getAllPlayer() {
        List<PlayerSoccer> playerSoccerList = playerSoccerService.findAll();
        if (playerSoccerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(playerSoccerList, HttpStatus.OK);
    }
    @GetMapping("/teams")
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teamList = teamService.findAll();
        return new ResponseEntity<>(teamList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<PlayerSoccer> detailPlayer(@PathVariable int id) {
        PlayerSoccer playerSoccer = playerSoccerService.findById(id);

        if (playerSoccer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(playerSoccer, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<List<PlayerSoccer>> addNewPlaySoccer(@RequestBody PlayerSoccer playerSoccer) {
        playerSoccerService.save(playerSoccer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //CẬP NHẬT
    @PutMapping("")
    public ResponseEntity<List<PlayerSoccer>> editPlayerSoccer(@RequestBody PlayerSoccer playerSoccer) {
        playerSoccerService.save(playerSoccer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
