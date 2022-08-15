package com.example.BaseballGame.repository;

import com.example.BaseballGame.domain.Room;
import com.example.BaseballGame.domain.Score;
import java.util.List;
import java.util.Optional;

//정답과 함께 유저의 입력값이 Score객체로 저장됨.

public interface ScoreRepository {
    Score save(Long roomId, Score score);
    Optional<Score> findById(Long roomId);
    List<Score> findAll(Long roomId);
}
