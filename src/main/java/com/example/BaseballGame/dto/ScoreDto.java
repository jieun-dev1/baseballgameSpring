package com.example.BaseballGame.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreDto {

    private boolean correct;
    private int remainingCount;
    private int strike;
    private int ball;
    private int out;

    public ScoreDto(boolean correct, int remainingCount, int strike, int ball, int out) {
        this.correct = correct;
        this.remainingCount = remainingCount;
        this.strike = strike;
        this.ball = ball;
        this.out = out;
    }
}
