package com.example.BaseballGame.infrastructure.config;

import com.example.BaseballGame.application.GameManager;
import com.example.BaseballGame.domain.GameAnswerGenerator;
import com.example.BaseballGame.domain.GameIdGenerator;
import com.example.BaseballGame.domain.repository.GameRepository;
import com.example.BaseballGame.domain.repository.HistoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public GameManager gameManager(GameAnswerGenerator gameAnswerGenerator, GameIdGenerator gameIdGenerator, GameRepository gameRepository, HistoryRepository historyRepository) {
        return new GameManager(gameAnswerGenerator, gameIdGenerator, gameRepository, historyRepository);
    }
}
