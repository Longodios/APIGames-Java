package com.example.game_service.services.impl;


import com.example.game_service.commons.entities.Game;
import com.example.game_service.commons.exceptions.GameException;
import com.example.game_service.repositories.GameRepository;
import com.example.game_service.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game saveGame(Game gameRequest){
        return gameRepository.save(gameRequest);
    }

    @Override
    public Game getGameById(String id) {
        return gameRepository.findById(Long.valueOf(id))
            .orElseThrow(() -> new RuntimeException("Error game not found"));
    }

    @Override
    public Game updateGame(String id, Game game) {
        return Optional.of(game)
                .map(gameUpdate -> {
                    gameUpdate.setId(Long.valueOf(id));
                    return gameRepository.save(gameUpdate);
                })
                .orElseThrow(() -> new GameException(HttpStatus.BAD_REQUEST, "Error Updating Game"));
    }

    @Override
    public Game deleteGame(String id) {
        return gameRepository.deleteGame(Long.valueOf(id));
    }



}
