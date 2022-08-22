package com.example.BaseballGame.domain.exception;

public class InvalidGameException extends RuntimeException {
    private String message = "존재하지 않는 roomId입니다. ";
    public InvalidGameException(String message) {
        this.message = message;
    }
}
