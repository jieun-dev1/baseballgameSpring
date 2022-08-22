package com.example.BaseballGame.shared.dto;


public class GameScoreResponse {
    private boolean correct;
    private int remainingCount;
    private int strike;
    private int ball;
    private int out;

    public GameScoreResponse(boolean correct, int remainingCount, int strike, int ball, int out) {
        this.correct = correct;
        this.remainingCount = remainingCount;
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

    public boolean isCorrect() {
        return correct;
    }

    public int getRemainingCount() {
        return remainingCount;
    }
}
