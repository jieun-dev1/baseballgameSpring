package com.example.BaseballGame.presentation;

/*
API 요청만 받는다.
 */

import com.example.BaseballGame.application.GameManager;
import com.example.BaseballGame.presentation.response.CurrentCount;
import com.example.BaseballGame.presentation.response.Histories;
import com.example.BaseballGame.shared.dto.ApiResponse;
import com.example.BaseballGame.presentation.response.GameStartResponse;
import com.example.BaseballGame.presentation.request.UserAnswerRequest;
import com.example.BaseballGame.presentation.request.GameScoreRequest;
import com.example.BaseballGame.presentation.response.GameScoreResponse;
import com.example.BaseballGame.presentation.request.GameStartRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
API 요청을 가장 먼저 받는 Controller 는 서비스 로직 실행 시 GameManager 에게 위임.
 */

@RestController
@RequestMapping(value = "game")
public class GameController {

    private GameManager gameManager;

    public GameController(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    //게임 시작
    @PostMapping("/start")
    public ApiResponse<GameStartResponse> gameStart() {
        GameStartRequest dto = gameManager.initializeGame(); //게임 매니저에게 게임 시작을 요청한다..
          return ApiResponse.success(GameStartResponse.from(dto));
    }

    @PostMapping("/{roomId}/answer")
    public ApiResponse<GameScoreResponse> gameRun(@PathVariable Long roomId, @RequestBody UserAnswerRequest userAnswer) {
        GameScoreRequest request = GameScoreRequest.from(roomId, userAnswer.getAnswer());
        GameScoreResponse result = gameManager.runGame(request);
        // * exception handler 에 fail 시 생성자 필요
        return ApiResponse.success(result);
    }


    @GetMapping("/{roomId}/history")
    public ApiResponse<Histories> checkHistories(@PathVariable Long roomId) {
        return ApiResponse.success(gameManager.findHistories(roomId));
    }


    @GetMapping("/{roomId}")
    public ApiResponse<CurrentCount> checkCurrentCount(@PathVariable Long roomId){
        return ApiResponse.success(gameManager.findCurrentCount(roomId));
    }

}
