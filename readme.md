## 숫자 야구 게임 API 구현

### 요구사항

[설계 시 유의]

데이터베이스 구현 기술은 결정되지 않은 상태라 db 없이 구현되어야 함 이후에 데이터베이스 구현 기술이 결정되면 db 연동이 추가되기 쉬워야 함

[게임 규칙]

- 답변은 최대 10번까지만 할 수 있다
- 답변 횟수가 최대치를 넘거나, 정답을 맞추는 경우 게임이 종료된 걸로 한다
- room id가 발급되고, 중복되지 않는 1-9 사이의 세 숫자가 정답으로 저장이 되어있어야 함(범위 지정 방법 고민)

*숫자의 범위는 0-9 사이로 변경될 가능성이 있음

### 구현 API 명세

```
게임 시작 (POST, /game/start)
response


{
    "success": true, //"gameOn"
    "data": {
        "roomId": 123
    }
    "error":null 
}
```

게임 진행 (POST /game/123/answer)

```
UserAnswerRequest

request
{
    "answer": "345"
}


```

response(게임 종료가 아닐 시)

```
UserAnswerResponse

{
    "success": true,
    "data->gameData": { 
        "correct": true, // false
        "remainingCount": 8,
        "strike": 3,
        "ball": 0,
        "out": 0
    }
	"error":null; 
}
```

response(게임 종료 시)

```

{
    "success": false,
    "data": null,
    "error": {
        "code": "CLOSED_GAME",
        "message": ""
    }
}

```

게임 결과 (GET /game/123)

```
response
{
    "success": true,
    "data": {
        "remainingCount": 8,
        "answerCount": 2
    }
    "error":null
}

```

게임 진행 기록 (GET /game/123/history)

```
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
    "error":null
}
```
