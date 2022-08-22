package com.example.BaseballGame.application;


import com.example.BaseballGame.domain.GameIdGenerator;
import java.util.concurrent.atomic.AtomicLong;

/*
특정 범위(ex.1-9)까지의 숫자로 랜덤숫자를 만듭니다.
volatile은 읽기 쓰기에 대한 동기화를 보장하고 연산에 대해서는 동기화를 보장하지 않으므로 AtomicLong을 사용.
 */
public class GameIdGeneratorImpl implements GameIdGenerator {
    private AtomicLong id = new AtomicLong(100L);

    @Override
    public Long generateRandomId() {
        return this.id.incrementAndGet();
    }
}
