package com.example.BaseballGame.repository;

import com.example.BaseballGame.domain.Room;
import java.util.Optional;

/*
역할: DB 변경에 대비할 수 있도록, Repository 구현체의 인터페이스 역할
책임: 구현체가 정해지기 전 메모리를 사용할 때는 GameMemoryRepository를 사용한다. 구현체에서 사용될 메서드를 정의한다.
협력: Room 객체를 받아서 저장한다.

 */
public interface GameRepository {
    Room save(Room room);
    Optional<Room> findById(Long roomId);
}
