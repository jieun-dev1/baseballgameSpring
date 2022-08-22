package com.example.BaseballGame.domain;

import java.util.List;

public interface HistoryRepository {
    void save(Long gameId, History history);
//    void findAll(Long gameId);
    List<History> findAll(Long gameId);
}
