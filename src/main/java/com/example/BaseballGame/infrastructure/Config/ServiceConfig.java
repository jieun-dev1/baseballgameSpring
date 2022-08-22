package com.example.BaseballGame.infrastructure.Config;

import com.example.BaseballGame.application.GameOperator;
import com.example.BaseballGame.domain.GameRepository;
import com.example.BaseballGame.domain.HistoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    //ServiceConfig
    //생성자와 중복되는지 확인 필요.
    @Bean
    public GameOperator gameOperator(GameRepository inMemoryGameRepository, HistoryRepository inMemoryHistoryRepository) {
        return new GameOperator(inMemoryGameRepository, inMemoryHistoryRepository);
    }
}
