package com.example.BaseballGame.persistence;

import com.example.BaseballGame.domain.Game;
import com.example.BaseballGame.domain.History;
import com.example.BaseballGame.domain.HistoryRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryHistoryRepository implements HistoryRepository {

    private static Map<Long, ArrayList<History>> historyStore = new HashMap<>();

    @Override
    public void save(Long gameId, History history) {
        //key가 없으면, 새로 만들기.
        if(historyStore.containsKey(gameId)) {
            historyStore.get(gameId).add(history);
        } else {
            ArrayList<History> histories = new ArrayList<>();
            histories.add(history);
            historyStore.put(gameId, histories);
        }
        //key가 있으면, 기존 key의 value에 add하기.
        // historyStore.put(gameId, history);
    }

    //key가 같은 value 들을 반환하기. return all value against one key in hashmap

    @Override
    public List<History> findAll(Long gameId) {
        return historyStore.get(gameId);
    }
}
