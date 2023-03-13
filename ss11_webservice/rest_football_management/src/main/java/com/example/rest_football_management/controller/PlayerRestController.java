package com.example.rest_football_management.controller;

import com.example.rest_football_management.model.Player;
import com.example.rest_football_management.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") //CORS
@RestController
@RequestMapping("/rest/player")
public class PlayerRestController {
    @Autowired
    private IPlayerService playerService;

    @GetMapping("")
    public ResponseEntity<List< Player>> getAllPlayer() {
        List<Player> playerList = playerService.getAllPlayer();
        if (playerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            return new ResponseEntity<>(playerList,HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Player> detail(@PathVariable int id) {
        Player player = playerService.findById(id);
        if (player == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<List<Player>> add(@RequestBody Player player) {
        playerService.save(player);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<List<Player>> edit(@RequestBody Player player) {
        playerService.save(player);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
