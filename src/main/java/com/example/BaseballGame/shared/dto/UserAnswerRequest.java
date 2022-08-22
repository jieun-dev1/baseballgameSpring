package com.example.BaseballGame.shared.dto;


public class UserAnswerRequest {
    private String answer;

    public UserAnswerRequest(String answer) {
        this.answer = answer;
    }

    public UserAnswerRequest() {
    }

    public String getAnswer() {
        return answer;
    }
}
