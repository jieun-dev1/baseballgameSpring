package com.example.BaseballGame.shared.dto;

public class GameStartResponse {
    private Long roomId;

    public GameStartResponse(Long roomId) {
        this.roomId = roomId;
    }

    public Long getRoomId() {
        return roomId;
    }

    //외부에서 생성자 from 의 매개변수를 파악할 수 없게, 객체로 감싼다.
    public static GameStartResponse from(GameStartRequest request) {
        return new GameStartResponse(request.getGameId());
    }
}
