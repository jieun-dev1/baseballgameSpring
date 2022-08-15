package com.example.BaseballGame.dto;

import com.example.BaseballGame.domain.Ball;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgramBallDto {
    private String balls;
    private ArrayList<Ball> ballList;

    public ProgramBallDto(String balls, ArrayList<Ball> ballList) {
        this.balls = balls;
        this.ballList = ballList;
    }
}
