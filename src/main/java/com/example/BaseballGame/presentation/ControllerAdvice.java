package com.example.BaseballGame.presentation;

import com.example.BaseballGame.domain.exception.GameClosedException;
import com.example.BaseballGame.domain.exception.InvalidGameException;
import com.example.BaseballGame.shared.dto.ApiResponse;
import com.example.BaseballGame.shared.dto.ApiResponse.Error;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
핸들러 매핑/핸들러 어댑터가 감지되면 동작함.
다양한 경우의 에러를 생성할 수 있게 만들어야 함.
 */

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(GameClosedException.class)
    public ApiResponse<?> closedGameHandler(GameClosedException e){
        return ApiResponse.fail(ApiResponse.Error.fromResult(e));
    }

    @ExceptionHandler(InvalidGameException.class)
    public ApiResponse<?> exceptionHandler(InvalidGameException e){
        return ApiResponse.fail(ApiResponse.Error.fromResult(e));
    }


}
