package com.example.BaseballGame.presentation.request;

public class GameStartRequest {

    private Long gameId;

    public Long getGameId() {
        return gameId;
    }

    public GameStartRequest(Long gameId) {
        this.gameId = gameId;
    }
}
