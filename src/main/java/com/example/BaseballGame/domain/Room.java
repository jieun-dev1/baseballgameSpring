package com.example.BaseballGame.domain;

/*
10의 기회가 주어지는 게임 한 번을 Room 이라고 한다.
Getter 와 Setter 를 만든다.

 */

import java.util.ArrayList;
import lombok.Getter;

@Getter
public class Room {

    private Long roomId;
    private int remainingCount = 10;
    private int answeredCount = 0;
    private String correctBalls; //correctBalls 는 Ball로 이루어진 BallList인게 비교하기 더 용이할 듯. //밖에 나가지 않는 값.
    private ArrayList<Ball> ballList;

    private boolean correct = false; //correct가 true 일 때, gameOpen 이 false가 된다.
    private boolean gameStatus = true; //gameOpen 이 false 가 되면 게임이 종료된다.


    //Getter
    public Long getRoomId() {
        return roomId;
    }

    public boolean isCorrect() {
        return correct;
    }

    public boolean getGameStatus() {
        return gameStatus;
    }

    //Setter
    public void setGameStatus(Boolean status) {
        this.gameStatus = status;
    }

    public void setRoomId(Long id) {
        this.roomId = id;
    }

    public void setCorrectBalls(String correctBalls) {
        this.correctBalls = correctBalls;
    }

    public void setBallList(ArrayList<Ball> ballList) {
        this.ballList = ballList;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public void changeGameCount(Long id) {
        remainingCount--;
        answeredCount++;
    }

    //생성자
    public Room() {
        this.roomId = roomId;
        this.remainingCount = remainingCount;
        this.answeredCount = answeredCount;
        this.correctBalls = null;
        this.ballList = null;
    }
}
