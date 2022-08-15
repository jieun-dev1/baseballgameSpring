package com.example.BaseballGame.dto;

import com.example.BaseballGame.domain.Score;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoryDto {
    private List<Score> scoreList;

    public HistoryDto(List<Score> history) {
        this.scoreList = history;
    }
}
