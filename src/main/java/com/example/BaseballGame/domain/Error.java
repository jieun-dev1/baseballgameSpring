package com.example.BaseballGame.domain;

/*
 */
public class Error {
    private Code code;
    private Enum message;

    public Error(Code code, Enum message) {
        this.code = code;
        this.message = message;
    }

    public Error(){

    }

    enum Code {
        CLOSED_GAME;
    }


}
