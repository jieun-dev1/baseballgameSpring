package com.example.BaseballGame.domain;

/*
Id 생성 규약의 변경에 대비해 Interface 생성
 */
public interface GameIdGenerator {
    Long generateRandomId();
}
