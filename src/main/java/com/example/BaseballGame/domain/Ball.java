package com.example.BaseballGame.domain;

import java.util.Objects;
import lombok.Getter;

/*
역할: 유자가 입력한 숫자 하나에 해당한다 (공은 채점을 위해, 인덱스와 checked 를 갖는다)
 */
@Getter
public class Ball {

    private char num;
    private int index;

    public Ball(char num, int index) {
        this.num = num;
        this.index = index;
    }

    public char getNum() {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ball)) {
            return false;
        }
        Ball ball = (Ball) o;
        return index == ball.index  && Objects.equals(num, ball.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, index);
    }
}

