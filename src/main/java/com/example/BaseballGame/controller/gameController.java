package com.example.BaseballGame.controller;

/*
게임 시작 (POST, /game/start)
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

public class gameController {

}
