package com.example.BaseballGame.infrastructure.Config;

import com.example.BaseballGame.domain.GameRepository;
import com.example.BaseballGame.domain.HistoryRepository;
import com.example.BaseballGame.persistence.InMemoryGameRepository;
import com.example.BaseballGame.persistence.InMemoryHistoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfig {
    @Bean
    public GameRepository inMemoryGameRepository(){
        return new InMemoryGameRepository();
    }

    @Bean
    public HistoryRepository inMemoryHistoryRepository() {
        return new InMemoryHistoryRepository();
    }
}
