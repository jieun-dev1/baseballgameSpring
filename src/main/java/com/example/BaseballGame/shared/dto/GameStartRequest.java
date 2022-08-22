package com.example.BaseballGame.shared.dto;

public class GameStartRequest {

    private Long gameId;

    public Long getGameId() {
        return gameId;
    }

    public GameStartRequest(Long gameId) {
        this.gameId = gameId;
    }
}
