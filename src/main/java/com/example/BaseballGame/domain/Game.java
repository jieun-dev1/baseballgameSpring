package com.example.BaseballGame.domain;

/*
Game 이 생성 될 떄, 총 참여 기회가 매개변수로 주어진다고 가정
 */

import com.example.BaseballGame.shared.dto.GameScoreRequest;
import com.example.BaseballGame.shared.dto.GameScoreResponse;
import com.example.BaseballGame.shared.dto.Score;

public class Game {

    private Long gameId;
    private int remainingCount;
    private int answeredCount;
    private String correctAnswer;
    private Status status;

    public enum Status{
        CLOSED, OPEN, CORRECT;
    }

    //생성자
    public Game(Long gameId, String correctAnswer, int remainingCount) {
        this.gameId = gameId;
        this.correctAnswer = correctAnswer;
        this.remainingCount = remainingCount;
    }

    public Game() {

    }

    //Getter
    public Long getGameId() {
        return gameId;
    }
    public Status getStatus() {
        return status;
    }

    //메서드
    public void changeGameCount() {
        this.remainingCount--;
        this.answeredCount++;
    }

    public int findStrikes(char[] userAnswerArray, char[] correctArray) {
        int strike = 0;
        for (int i = 0; i < userAnswerArray.length; i++) {
            if (userAnswerArray[i] == correctArray[i]) {
                strike++;
            }
        }
        return strike;
    }

    public int findBalls(char[] userAnswerArray, char[] correctArray) {
        int ball = 0;

        for (int i = 0; i < userAnswerArray.length; i++) {
            for (int j = 0; j < correctArray.length; j++) {
                if (userAnswerArray[i] == correctArray[i] && (i != j)) {
                    ball++;
                    break;
                }
            }
        }
        return ball;
    }

    public GameScoreResponse scoreBalls(GameScoreRequest dto) {

        String userAnswer = dto.getUserAnswerRequest().getAnswer();
        char[] userAnswerArray = userAnswer.toCharArray();
        char[] correctArray = this.correctAnswer.toCharArray();

        int strike = findStrikes(userAnswerArray, correctArray);
        int ball = findBalls(userAnswerArray, correctArray);
        int out = 3 - strike - ball;

        /*
        게임 상태 변경 필요
        (1) 게임 남은 카운트 -1.
        (2) 게임 Status 판단.
         */
        this.changeGameCount();

        if(strike == 3) {
            this.status = Status.CORRECT;
        } else if (remainingCount<=0) {
            this.status = Status.CLOSED;
        }

        //서비스에 Score 객체를 반환.
        //Room 의 remainingCount등과 함께 반환.

        return new GameScoreResponse((this.status == Status.CORRECT) ,this.remainingCount, strike, ball, out);
    }
}
