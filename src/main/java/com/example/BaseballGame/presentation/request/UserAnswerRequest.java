package com.example.BaseballGame.presentation.request;

public class UserAnswerRequest {

    private String answer;
    public String getAnswer() {
        return answer;
    }
    public UserAnswerRequest() {
    }

    public UserAnswerRequest(String answer) {
        this.answer = answer;
    }
}
