package com.example.BaseballGame.application;

import com.example.BaseballGame.domain.GameIdGenerator;

public class FixedGameAnswerGenerator implements GameIdGenerator {

    @Override
    public Long generateRandomId() {
        Long id = 123L;
        return id;
    }
}
