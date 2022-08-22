package com.example.BaseballGame.shared.dto;

public class Score {
    private int strike;
    private int ball;
    private int out;

    public Score(int strike, int ball, int out) {
        this.strike = strike;
        this.ball = ball;
        this.out = out;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getOut() {
        return out;
    }
}
