package com.example.BaseballGame.shared.dto;

/*
DTO의 내부 구현을 외부에서 볼 수 없게 캡슐화.
Controller 에서 응답을 공통 처리해주는 클래스

Error
내부 클래스의 적용
-외부의 불필요한 클래스를 감춤으로써 코드의 복잡성을 줄임 (캡슐화)
-내부 클래스에서 외부 클래스의 멤버 변수에 쉽게 접근 가능
 */

import com.example.BaseballGame.domain.exception.GameClosedException;
import com.example.BaseballGame.domain.exception.InvalidGameException;
import com.example.BaseballGame.presentation.response.CurrentCount;
import com.example.BaseballGame.presentation.response.GameScoreResponse;
import com.example.BaseballGame.presentation.response.GameStartResponse;
import com.example.BaseballGame.presentation.response.Histories;

    public class ApiResponse<T>  {

    private boolean success;
    private T data;
    private Error error;

    public ApiResponse(boolean success, T data, Error error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public Error getError() {
        return error;
    }

    public static <T> ApiResponse<T> success(GameStartResponse response) {
        return new ApiResponse(true, response, null);
    }

    public static <T> ApiResponse<T> success(GameScoreResponse response) {
        return new ApiResponse(true, response, null);
    }

    public static <T> ApiResponse<T> success(Histories histories) {
        return new ApiResponse(true, histories, null);
    }

    public static <T> ApiResponse<T> success(CurrentCount currentCount) {
        return new ApiResponse(true, currentCount, null);
    }

    public static <T> ApiResponse<T> fail(Error error) {
        return new ApiResponse(false, null, error);
    }

    /*
    Error를 public static으로 만든 이유 - 외부에서 참조하기 위함.
     */
    public static class Error {

        private Code code;
        private String message;

        public Error(Code code, String message) {
            this.code = code;
            this.message = message;
        }

        public enum Code {
            CLOSED_GAME, NOT_EXIST;
        }

        public Code getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public static Error fromResult(GameClosedException e) {
            return new Error(Code.CLOSED_GAME,e.getMessage());
        }

        public static Error fromResult(InvalidGameException e) {
            return new Error(Code.NOT_EXIST, e.getMessage());
        }
    }
}