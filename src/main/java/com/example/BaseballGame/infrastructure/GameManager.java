package com.example.BaseballGame.infrastructure;

import com.example.BaseballGame.domain.Game;
import com.example.BaseballGame.domain.GameRepository;
import com.example.BaseballGame.domain.GameAnswerGenerator;
import com.example.BaseballGame.application.GameOperator;
import com.example.BaseballGame.domain.GameIdGenerator;
import com.example.BaseballGame.shared.dto.GameScoreRequest;
import com.example.BaseballGame.shared.dto.GameScoreResponse;
import com.example.BaseballGame.shared.dto.GameStartRequest;

/*
파사드가 어느 계층에 어울리는지 확인 필요.
-게임 매니저는 인터페이스에 의존하고, 구현체는 Config 에서 생성해서 갈아끼울 수 있도록 했다.
-GameManager의 책임: 중앙에서 관리한다.
-
초기화 담당 - 실질적인 채점 등은 GameOPerator 에게 위임
 */

public class GameManager {

    private GameAnswerGenerator answerGenerator;
    private GameIdGenerator idGenerator;
    private GameOperator gameOperator;
    private GameRepository repository;

    public GameManager(GameAnswerGenerator answerGenerator,
            GameIdGenerator idGenerator, GameOperator gameOperator,
            GameRepository repository) {
        this.answerGenerator = answerGenerator;
        this.idGenerator = idGenerator;
        this.gameOperator = gameOperator;
        this.repository = repository;
    }

    /*
        1.Id를 만들어줘.
        2. 게임에 쓰일 Random 이름도 만들어줘.
        언제 static?
         */
    public GameStartRequest initializeGame(){
        Long id = idGenerator.generateRandomId(); //roomId를 생성해서 반환.
        String answer = answerGenerator.generateGameAnswer(); // String답을 생성해서 반환.
        repository.save(new Game(id, answer, 10)); //총 count도 같이 준다.
        //두 값의 리턴으로 생성자 만들어서 room 중 id 를 빼서 DTO로 만들기.
        GameStartRequest dto = new GameStartRequest(id);
        return dto;
    }

    public GameScoreResponse runGame(GameScoreRequest dto){
        //gameOperator 에게 채점 의뢰
        GameScoreResponse result = gameOperator.scoreGame(dto);
        return result;
    }



    /*
    게임을 진행하면서
    1.
     */
}
