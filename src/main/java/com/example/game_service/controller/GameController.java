package com.example.game_service.controller;

import com.example.game_service.entities.Game;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/games")
public class GameController {
    @PostMapping
    public ResponseEntity<Game> saveGame(@RequestBody Game game){
        return ResponseEntity.ok(game);
    }
}
