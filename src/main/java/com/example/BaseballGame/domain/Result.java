package com.example.BaseballGame.domain;


import lombok.Getter;

@Getter
public class Result {
    private int strike;
    private int ball;
    private int out;

    public Result(int strike, int ball, int out) {
        this.strike = strike;
        this.ball = ball;
        this.out = out;
    }
}
