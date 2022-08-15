package com.example.BaseballGame.repository;

import com.example.BaseballGame.domain.Score;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreMemoryRepository implements ScoreRepository {

    private static Map<Long, Score> scoreStore = new HashMap<>();

    @Override
    public Score save(Long roomId, Score score) {
        scoreStore.put(roomId, score);
        return score;
    }

    @Override
    public Optional<Score> findById(Long roomId) {
        return Optional.ofNullable(scoreStore.get(roomId));
    }

    @Override
    public List<Score> findAll(Long roomId) {
        List<Score> scoreList = new ArrayList<>();
        scoreList.add(scoreStore.get(roomId));
        return scoreList;
    }
}
