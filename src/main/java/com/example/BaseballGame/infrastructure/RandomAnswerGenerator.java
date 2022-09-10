package com.example.BaseballGame.infrastructure;

/*
랜덤으로 3자리 숫자를 생성한다. 1부터 9로만 이루어져 한다. 각 자리의 수가 겹치면 안된다.
 */

import com.example.BaseballGame.domain.GameAnswerGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomAnswerGenerator implements GameAnswerGenerator {
    private int min;
    private int max;

    public RandomAnswerGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    /*
    Math.random(0.0 - 1에 무한히 가까운 수를 제공
    겹치지 않게

    range: 순차적으로 반환함 (첫번째 - 마지막 수)
    boxed(): Integer로 박싱된 요소들로 구성된 스트림을 반환함.
    toCollection(ArrayList::new):ArrayList를 만들고, 스트림의 모든 요소들 더함.
    Collectors.shuffle(): 무작위로 값을 돌림.
     */
    @Override
    public String generateGameAnswer() {
        StringBuilder sb = new StringBuilder();
        List<String> list = IntStream.range(1,9).boxed().map(i -> i.toString()).collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(list);
        for(int i=0;i<3;i++){
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
