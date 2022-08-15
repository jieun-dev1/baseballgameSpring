package com.example.BaseballGame.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameResultDto {
    private int remainingCount;
    private int answeredCount;

    public GameResultDto(int remainingCount, int answeredCount) {
        this.remainingCount = remainingCount;
        this.answeredCount = answeredCount;
    }
}
