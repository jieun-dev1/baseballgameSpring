package com.example.BaseballGame.domain.repository;

import com.example.BaseballGame.domain.History;
import com.example.BaseballGame.presentation.response.Histories;
import java.util.List;

public interface HistoryRepository {
    void save(Long gameId, History history);
    List<History> findAll(Long gameId);
}
