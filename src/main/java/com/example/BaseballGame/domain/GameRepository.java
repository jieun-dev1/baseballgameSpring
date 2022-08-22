package com.example.BaseballGame.domain;

import java.util.Optional;

//저장소.
public interface GameRepository {

    Game save(Game game);
    Game findById(Long gameId);
}
