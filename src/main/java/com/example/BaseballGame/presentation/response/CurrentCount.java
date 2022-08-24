package com.example.BaseballGame.presentation.response;

public class CurrentCount {
    private int remainingCount;
    private int answeredCount;

    public CurrentCount(int remainingCount, int answeredCount) {
        this.remainingCount = remainingCount;
        this.answeredCount = answeredCount;
    }

    public int getRemainingCount() {
        return this.remainingCount;
    }

    public int getAnsweredCount() {
        return this.answeredCount;
    }

    public static CurrentCount of(int remainingCount, int answeredCount){
        return new CurrentCount(remainingCount,answeredCount);
    }
}