package com.example.BaseballGame.controller;

/*

게임 시작 (POST, /game/start)
post: 서버의 상태를 바꾸는 (무상태 -> 게임 시작의 상태)

response

{
    "success": true, //"gameOn" x
    "data": {
        "roomId": 123 o
    }
}

게임 진행 (POST /game/123/answer)
request
{
    "answer": "345" o
}

response(게임 종료가 아닐 시)

{
    "success": true, x
    "data": {
        "correct": true, // false
        "remainingCount": 8,
        "strike": 3,
        "ball": 0,
        "out": 0
    }
}

response(게임 종료 시)

{
    "success": false,
    "data": null,
    "error": {
        "code": "CLOSED_GAME",
        "message": ""
    }
}

게임 결과 (GET /game/123)
response

{
    "success": true,
    "data": {
        "remainingCount": 8,
        "answerCount": 2
    }
}

게임 진행 기록 (GET /game/123/history)
response

{
    "success": true,
    "data": {
        histories: [
            {
                "answer": "123",
                "result": {
                    "strike": 0,
                    "ball": 0,
                    "out": 3
                }
            },
            {
                "answer": "456",
                "result": {
                    "strike": 0,
                    "ball": 2,
                    "out": 1
                }
            }
        ]
    }
}
 */

import com.example.BaseballGame.domain.Room;
import com.example.BaseballGame.dto.GameNotAvailableDto;
import com.example.BaseballGame.dto.GameResultDto;
import com.example.BaseballGame.dto.GameStartDto;
import com.example.BaseballGame.dto.HistoryDto;
import com.example.BaseballGame.dto.ScoreDto;
import com.example.BaseballGame.dto.UserBallDto;
import com.example.BaseballGame.service.GameService;
import com.example.BaseballGame.service.ScoreService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
답변은 최대 10번까지만 할 수 있다 (answer)
답변 횟수가 최대치를 넘거나, 정답을 맞추는 경우 게임이 종료된 걸로 한다
room id가 발급되고, 중복되지 않는 1-9 사이의 세 숫자가 정답으로 저장이 되어있어야 함(범위 지정 방법 고민)
숫자의 범위는 0-9 사이로 변경될 가능성이 있음

 */

/*
@RestController //스프링에게 RestAPI 컨트롤러 사용을 알려줌.
@requestMapping http://localhost:8080/game 처럼 url 이 매핑됨.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "game")
public class GameController {

    private final GameService gameService;
    private final ScoreService scoreService;

    //게임 시작
    @PostMapping("/start")
    public ResponseEntity<Map<String, Object>> gameStart() {
        // 추후에 dto -> gameData 반환 고려. #success.True 와 같이 리턴해줘야 하니, DTO 등으로 반환 고려.
        Room room = gameService.saveRoom();
        GameStartDto dto = new GameStartDto(room.getRoomId());
        Map<String, Object> result = new HashMap<>();
        result.put("data", dto);
        result.put("success", true);
        return ResponseEntity.ok().body(result);
    }

    /*
     게임 진행 - 룸에 들어가서, 유저가 값을 입력한다.
     (1) 게임이 열려있을 경우 (진행중) / (2) 종료되었을 경우
     */

    @PostMapping("/{roomId}/answer")
    public ResponseEntity<Map<String, Object>> gameRun(@PathVariable Long roomId, @RequestBody UserBallDto UserAnswerDto) {
        //게임 Id 가 있다면 -> Room 을 리턴하고, 없다면 Exception
        Boolean gameAlive = gameService.validateRoomAlive(roomId);
        Map<String, Object> result = new HashMap<>();

        //gameAlive 는 기본이 true
        if(gameAlive) {
            ScoreDto dto = scoreService.scoreBalls(UserAnswerDto.getAnswer(), roomId);
            result.put("success", true);
            result.put("data", dto);
            return ResponseEntity.ok().body(result);
        //게임 종료
        } else {
            GameNotAvailableDto dto = gameService.gameIsNotAvailable();
            result.put("success", false);
            result.put("data", null);
            result.put("error", dto);
            return ResponseEntity.ok().body(result);
        }
    }

    /*
     룸 상태 조회 (남은 횟수, 현재 열려있는지 여부 등)
     */

    @GetMapping("/{roomId}")
    public ResponseEntity<Map<String, Object>> getGameResult(@PathVariable Long roomId) {
        Map<String, Object> result = new HashMap<>();
        GameResultDto dto = gameService.getResult(roomId);
        result.put("success", true);
        result.put("data", dto);
        return ResponseEntity.ok().body(result);
    }

    //
    @GetMapping("/{roomId}/history")
    public ResponseEntity<Map<String, Object>> gameHistories (@PathVariable Long roomId) {
        Map<String, Object> result = new HashMap<>();
        HistoryDto dto = gameService.getHistories(roomId);
        result.put("success", true);
        result.put("data", dto);
        return ResponseEntity.ok().body(result);
    }
}
