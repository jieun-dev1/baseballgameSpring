package com.example.BaseballGame.domain;

import lombok.Getter;

//정답과 함께 유저의 입력값이 Score객체로 저장됨.

@Getter
public class Score {
    private String userBalls;
    private Result result;

    public Score(String userBalls, Result result) {
        this.userBalls = userBalls;
        this.result = result;
    }
}
