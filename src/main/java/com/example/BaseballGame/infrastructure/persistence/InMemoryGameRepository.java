package com.example.BaseballGame.infrastructure.persistence;


import com.example.BaseballGame.domain.Game;
import com.example.BaseballGame.domain.exception.InvalidGameException;
import com.example.BaseballGame.domain.repository.GameRepository;
import java.util.HashMap;
import java.util.Map;


public class InMemoryGameRepository implements GameRepository {

    private static Map<Long, Game> store = new HashMap<>();


    @Override
    public Game save(Game game) {
        store.put(game.getGameId(), game);
        return game;
    }

    @Override
    public Game findById(Long gameId) {
        Game game = store.get(gameId);
        if(game == null) {
            throw new InvalidGameException("존재하지 않는 게임 입니다");
        }
        return game;
    }

}
