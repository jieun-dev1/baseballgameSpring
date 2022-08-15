package com.example.BaseballGame.repository;

import com.example.BaseballGame.domain.Room;
import com.example.BaseballGame.domain.Score;
import java.util.List;
import java.util.Optional;

public interface ScoreRepository {
    Score save(Long roomId, Score score);
    Optional<Score> findById(Long roomId);
    List<Score> findAll(Long roomId);
}
