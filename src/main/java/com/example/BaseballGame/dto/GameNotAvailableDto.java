package com.example.BaseballGame.dto;

import com.example.BaseballGame.domain.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameNotAvailableDto {

    private ErrorCode error;

    public GameNotAvailableDto(ErrorCode error) {
        this.error = error;
    }
}
