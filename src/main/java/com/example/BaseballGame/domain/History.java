package com.example.BaseballGame.domain;

import com.example.BaseballGame.shared.dto.Score;

public class History {

    private String userAnswer;
    private Score score;

    public History(String userAnswer, Score score) {
        this.userAnswer = userAnswer;
        this.score = score;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public Score getScore() {
        return score;
    }
}
