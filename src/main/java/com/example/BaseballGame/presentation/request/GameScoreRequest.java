package com.example.BaseballGame.presentation.request;


public class GameScoreRequest {

    private Long roomId;
    private String answer;

    public GameScoreRequest(Long roomId, String answer) {
        this.roomId = roomId;
        this.answer = answer;
    }


    public Long getRoomId() {
        return this.roomId;
    }

    public String getAnswer() {
        return this.answer;
    }


    public static GameScoreRequest from(Long roomId, String answer) {
        return new GameScoreRequest(roomId, answer);
    }
}
