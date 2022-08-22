package com.example.BaseballGame.application;

import com.example.BaseballGame.domain.Game.Status;
import com.example.BaseballGame.domain.GameRepository;
import com.example.BaseballGame.domain.History;
import com.example.BaseballGame.domain.HistoryRepository;
import com.example.BaseballGame.domain.exception.GameClosedException;
import com.example.BaseballGame.domain.exception.InvalidGameException;
import com.example.BaseballGame.domain.Game;
import com.example.BaseballGame.shared.dto.GameScoreRequest;
import com.example.BaseballGame.shared.dto.GameScoreResponse;
import com.example.BaseballGame.shared.dto.Score;


public class GameOperator {

    private GameRepository repository;
    private HistoryRepository historyRepository;

    public GameOperator() {
    }

    public GameOperator(GameRepository inMemoryGameRepository, HistoryRepository inMemoryHistoryRepository) {
        this.repository = inMemoryGameRepository;
        this.historyRepository = inMemoryHistoryRepository;
    }

    //목적: 채점
    public GameScoreResponse scoreGame(GameScoreRequest dto) {
        Game game = repository.findById(dto.getRoomId());
        //게임이 존재하는지 확인
        if(game==null) {
            throw new InvalidGameException("존재하지 않는 게임 입니다");
        }
        /*
        게임이 살아있는지 확인하고, 그렇다면 채점해서 점수를 넣는다.
         */
        ;
        if (game.getStatus() == Status.CLOSED || game.getStatus() == Status.CORRECT){
            throw new GameClosedException("종료된 게임입니다");
        }
        //채점 결과 반환
        GameScoreResponse response = game.scoreBalls(dto);
        Score score = new Score(response.getStrike(), response.getBall(), response.getStrike());
        //반환 받은 game 결과를 repository에 저장한다.
        History history = new History(dto.getUserAnswerRequest().getAnswer(), score);
        historyRepository.save(game.getGameId(), history);
        return response;
    }
}


