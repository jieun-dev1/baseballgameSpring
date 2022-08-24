package com.example.BaseballGame.domain.repository;

import com.example.BaseballGame.domain.Game;

public interface GameRepository {

    Game save(Game game);
    Game findById(Long gameId);
}
