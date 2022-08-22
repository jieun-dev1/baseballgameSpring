package com.example.BaseballGame.shared.dto;

/*
DTO의 내부 구현을 외부에서 볼 수 없게 캡슐화.
Controller 에서 응답을 공통 처리해주는 클래스
 */

public class ApiResponse<T> {
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
}
