package com.example.BaseballGame.infrastructure;


import com.example.BaseballGame.domain.GameIdGenerator;
import java.util.concurrent.atomic.AtomicLong;

/*
100부터 순차적으로 Id가 증가함. Id 생성 전략이 바뀔 가능성 대비하여 구현체 생성.
volatile은 읽기 쓰기에 대한 동기화를 보장하고 연산에 대해서는 동기화를 보장하지 않으므로 AtomicLong을 사용.
 */
public class IncrementalGameIdGenerator implements GameIdGenerator {
    private AtomicLong id = new AtomicLong(100L);

    @Override
    public Long generateRandomId() {
        return this.id.incrementAndGet();
    }
}
