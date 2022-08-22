package com.example.BaseballGame.infrastructure.Config;

import com.example.BaseballGame.domain.GameRepository;
import com.example.BaseballGame.domain.GameAnswerGenerator;
import com.example.BaseballGame.application.GameAnswerGeneratorImpl;
import com.example.BaseballGame.application.GameOperator;
import com.example.BaseballGame.domain.HistoryRepository;
import com.example.BaseballGame.domain.GameIdGenerator;
import com.example.BaseballGame.application.GameIdGeneratorImpl;
import com.example.BaseballGame.infrastructure.GameManager;
import com.example.BaseballGame.persistence.InMemoryHistoryRepository;
import com.example.BaseballGame.persistence.InMemoryGameRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
스프링 프레임워크에 의지하지 않고, 직접 자바 빈 등록.
게임 매니저 생성 시 구현체 지정.
    private GameAnswerGenerator answerGenerator;
    private RoomIdGenerator idGenerator;
    private GameOperator gameOperator;
    private GameRepository repository;

GameOperator 생성 시 구현체 지정
    private GameRepository repository;
    private HistoryRepository historyRepository;
 */
@Configuration
public class GameConfig {
    @Bean
    public GameManager gameManager(GameAnswerGenerator gameAnswerGeneratorImpl, GameIdGenerator roomIdGeneratorImpl, GameOperator gameOperator, GameRepository inMemoryGameRepository) {
        return new GameManager(gameAnswerGeneratorImpl, roomIdGeneratorImpl, gameOperator, inMemoryGameRepository);
    }

    @Bean
    public GameAnswerGenerator gameAnswerGeneratorImpl(){
        return new GameAnswerGeneratorImpl(1, 9);
    }

    @Bean
    public GameIdGenerator roomIdGeneratorImpl(){
        return new GameIdGeneratorImpl();
    }

    //구현체 바꾸지 않고 그대로 생성.



}
