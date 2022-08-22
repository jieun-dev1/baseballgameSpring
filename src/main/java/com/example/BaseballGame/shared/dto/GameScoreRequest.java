package com.example.BaseballGame.shared.dto;

public class GameScoreRequest {

    private Long roomId;
    private UserAnswerRequest answer;

    public GameScoreRequest(Long roomId, UserAnswerRequest answer) {
        this.roomId = roomId;
        this.answer = answer;
    }

    public Long getRoomId() {
        return roomId;
    }

    public UserAnswerRequest getUserAnswerRequest() {
        return answer;
    }
}
