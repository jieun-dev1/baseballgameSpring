package com.example.BaseballGame.presentation.response;


import com.example.BaseballGame.shared.dto.Score;

public class GameScoreResponse {

    private boolean correct;
    private int remainingCount;
    private Score score;

    public GameScoreResponse(boolean correct, int remainingCount,
            Score score) {
        this.correct = correct;
        this.remainingCount = remainingCount;
        this.score = score;
    }

    public boolean isCorrect() {
        return correct;
    }

    public int getRemainingCount() {
        return remainingCount;
    }

    public Score getScore() {
        return score;
    }
}
