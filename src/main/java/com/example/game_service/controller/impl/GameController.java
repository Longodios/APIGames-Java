package com.example.game_service.controller.impl;

import com.example.game_service.commons.entities.Game;
import com.example.game_service.controller.GameApi;
import com.example.game_service.services.GameService;
import com.example.game_service.services.impl.GameServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController implements GameApi {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public ResponseEntity<Game> saveGame(Game game){
       Game gameCreated = gameService.saveGame(game);
       return ResponseEntity.ok(gameCreated);
    }

    @Override
    public ResponseEntity<Game> getGamebyId(String id) {
        return ResponseEntity.ok(gameService.getGameById(id));
    }

    @Override
    public ResponseEntity<Game> updateGame(String id, Game game) {
        return ResponseEntity.ok(gameService.updateGame(id, game));
    }

    @Override
    public ResponseEntity<Game> deleteGame(String id) {
        return ResponseEntity.ok(gameService.deleteGame(id));
    }
}
