package com.example.BaseballGame.persistence;


import com.example.BaseballGame.domain.Game;
import com.example.BaseballGame.domain.GameRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class InMemoryGameRepository implements GameRepository {

    private static Map<Long, Game> store = new HashMap<>();


    @Override
    public Game save(Game game) {
        store.put(game.getGameId(), game);
        return game;
    }

    @Override
    public Game findById(Long gameId) {
        return store.getOrDefault(gameId, null);
    }

}
