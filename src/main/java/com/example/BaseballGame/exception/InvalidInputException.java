package com.example.BaseballGame.exception;

public class InvalidInputException extends RuntimeException {
    private String message = "존재하지 않는 roomId입니다. ";

    public InvalidInputException(String message) {
        this.message = message;
    }
}
