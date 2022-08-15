package com.example.BaseballGame.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorCode {
    private String code;
    private String message;

    public ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
