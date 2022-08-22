package com.example.BaseballGame.application;

/*
랜덤으로 3자리 숫자를 생성한다. 1부터 9로만 이루어져한다. 한 자리씩 만들어서 합친다.
 */

import com.example.BaseballGame.domain.GameAnswerGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameAnswerGeneratorImpl implements GameAnswerGenerator {
    private int min;
    private int max;

    public GameAnswerGeneratorImpl(int min, int max) {
        this.min = min;
        this.max = max;
    }

    /*
    Math.random(0.0 - 1에 무한히 가까운 수를 제공)
     */
    @Override
    public String generateGameAnswer() {
        Random random = new Random();
        List<Character> numList = new ArrayList<>();
        List<Integer> numList2 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        random.setSeed(System.currentTimeMillis());
        for(int i=0;i<3;i++) {
            int num = (int)(Math.random()*(this.max - this.min + 1)+1);
            sb.append(num);

        }
        return sb.toString();
    }
}
