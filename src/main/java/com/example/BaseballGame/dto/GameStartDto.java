package com.example.BaseballGame.dto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GameStartDto {

    private Long roomId;

    public GameStartDto(Long roomId) {
        this.roomId = roomId;
    }
}
