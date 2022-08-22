package com.example.BaseballGame.domain.exception;

public class GameClosedException extends RuntimeException {
    private String message = "존재하지 않는 roomId입니다. ";
    public GameClosedException(String message) {
        this.message = message;
    }
}
