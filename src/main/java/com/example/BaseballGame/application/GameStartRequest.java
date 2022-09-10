package com.example.BaseballGame.application;

public class GameStartRequest {

    private Long gameId;

    public Long getGameId() {
        return gameId;
    }

    public GameStartRequest(Long gameId) {
        this.gameId = gameId;
    }
}
