package com.example.BaseballGame.infrastructure.config;

import com.example.BaseballGame.domain.repository.GameRepository;
import com.example.BaseballGame.domain.repository.HistoryRepository;
import com.example.BaseballGame.infrastructure.persistence.InMemoryGameRepository;
import com.example.BaseballGame.infrastructure.persistence.InMemoryHistoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfig {


    @Bean
    public GameRepository gameRepository(){
        return new InMemoryGameRepository();
    }

    @Bean
    public HistoryRepository historyRepository() {
        return new InMemoryHistoryRepository();
    }
}
