package com.example.BaseballGame.application;

import com.example.BaseballGame.domain.Game;
import com.example.BaseballGame.domain.Game.Status;
import com.example.BaseballGame.domain.repository.GameRepository;
import com.example.BaseballGame.domain.GameAnswerGenerator;
import com.example.BaseballGame.domain.GameIdGenerator;
import com.example.BaseballGame.domain.History;
import com.example.BaseballGame.domain.repository.HistoryRepository;
import com.example.BaseballGame.domain.exception.GameClosedException;
import com.example.BaseballGame.domain.exception.InvalidGameException;
import com.example.BaseballGame.presentation.response.CurrentCount;
import com.example.BaseballGame.presentation.request.GameScoreRequest;
import com.example.BaseballGame.presentation.response.GameScoreResponse;
import com.example.BaseballGame.presentation.request.GameStartRequest;
import com.example.BaseballGame.presentation.response.Histories;
import java.util.List;

/*
역할: 게임 아이디/정답 생성기 및 repository와 협력하며, 중앙에서 관리한다.
책임: 게임 매니저는 인터페이스에 의존하고, 구현체는 Config 에서 생성해서 갈아끼울 수 있도록 했다.
 */

public class GameManager {

    private GameAnswerGenerator answerGenerator;
    private GameIdGenerator idGenerator;
    private GameRepository repository;
    private HistoryRepository historyRepository;


    public GameManager(GameAnswerGenerator answerGenerator,
            GameIdGenerator idGenerator,
            GameRepository repository,
            HistoryRepository historyRepository) {
        this.answerGenerator = answerGenerator;
        this.idGenerator = idGenerator;
        this.repository = repository;
        this.historyRepository = historyRepository;
    }

    /*
        게임 시작 준비
        1. 게임 아이디 생성 요청
        2. 게임에 쓰일 랜덤 아이디 생성 요청
     */
    public GameStartRequest initializeGame() {
        Long id = idGenerator.generateRandomId(); //roomId를 생성해서 반환.
        String answer = answerGenerator.generateGameAnswer(); // String 답을 생성해서 반환.
        repository.save(new Game(id, answer, 10)); //총 count도 함께 지정
        //두 값의 리턴으로 생성자 만들어서 room 중 id 를 빼서 DTO로 만들기.
        GameStartRequest dto = new GameStartRequest(id);
        return dto;
    }

    public GameScoreResponse runGame(GameScoreRequest request) {
        Game game = repository.findById(request.getRoomId());

        /*
        게임이 살아있는지 확인하고, 그렇다면 채점해서 점수를 넣는다.
         */

        if (game.getStatus() == Status.CLOSED || game.getStatus() == Status.CORRECT) {
            throw new GameClosedException("종료된 게임입니다");
        }
        //채점 결과 반환
        GameScoreResponse response = game.scoreBalls(request);
        //반환 받은 game 결과를 repository에 저장한다.
        History history = new History(request.getAnswer(), response.getScore());
        historyRepository.save(game.getGameId(), history);
        return response;
    }

    public CurrentCount findCurrentCount(Long gameId) {
        Game game = repository.findById(gameId);
        return CurrentCount.of(game.getRemainingCount(), game.getAnsweredCount());
    }

    public Histories findHistories(Long gameId) {
        repository.findById(gameId);
        List<History> historyList = historyRepository.findAll(gameId);
        Histories histories = new Histories(historyList);
        return histories;
    }

}
