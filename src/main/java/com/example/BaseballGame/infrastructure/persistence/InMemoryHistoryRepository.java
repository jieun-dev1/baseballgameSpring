package com.example.BaseballGame.infrastructure.persistence;

import com.example.BaseballGame.domain.History;
import com.example.BaseballGame.domain.repository.HistoryRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryHistoryRepository implements HistoryRepository {

    private static Map<Long, ArrayList<History>> historyStore = new HashMap<>();

    @Override
    public void save(Long gameId, History history) {
        if(historyStore.containsKey(gameId)) {
            historyStore.get(gameId).add(history);
        } else {
            ArrayList<History> histories = new ArrayList<>();
            histories.add(history);
            historyStore.put(gameId, histories);
        }
    }

    @Override
    public List<History> findAll(Long gameId) {
        return historyStore.get(gameId);
    }
}
