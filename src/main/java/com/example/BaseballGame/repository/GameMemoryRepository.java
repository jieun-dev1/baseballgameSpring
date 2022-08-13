package com.example.BaseballGame.repository;

import com.example.BaseballGame.domain.Room;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
Room을 save 할 때, setId를 해줄 것.
역할:
책임: Map에 Id(key) Room 객체를(Value) 저장해서, Id 검색으로 Room 객체 조회가 가능하다.
 */
public class GameMemoryRepository implements GameRepository {

    private Map<Long, Room> store = new HashMap<>();
    private static long sequence = 1L; //유일값으로 참조되면서 ++ 되기 때문에, 고유id 가 된다.

    @Override
    public Room save(Room room) {
        room.setRoomId(sequence++);
        return room;
    }

    @Override
    public Optional<Room> findById(Long roomId) {
        return Optional.ofNullable(store.get(roomId));
    }
}
