package com.example.BaseballGame.infrastructure;

import com.example.BaseballGame.domain.GameAnswerGenerator;

public class FixedGameAnswerGenerator implements GameAnswerGenerator {

    @Override
    public String generateGameAnswer() {
        String id = "123";
        return id;
    }
}
