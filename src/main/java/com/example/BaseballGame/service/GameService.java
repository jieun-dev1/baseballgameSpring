package com.example.BaseballGame.service;

import com.example.BaseballGame.domain.Ball;
import com.example.BaseballGame.domain.Room;
import com.example.BaseballGame.domain.ErrorCode;
import com.example.BaseballGame.domain.Score;
import com.example.BaseballGame.dto.GameNotAvailableDto;
import com.example.BaseballGame.dto.GameResultDto;
import com.example.BaseballGame.dto.HistoryDto;
import com.example.BaseballGame.dto.ProgramBallDto;
import com.example.BaseballGame.exception.InvalidInputException;
import com.example.BaseballGame.repository.GameMemoryRepository;
import com.example.BaseballGame.repository.GameRepository;
import com.example.BaseballGame.repository.ScoreRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/*
역할
- gameSetting: 랜덤으로 첫 input 값을 생성
- 게임을 채점
 */
@RequiredArgsConstructor
@Service
public class GameService {

    private final GameRepository gameRepository = new GameMemoryRepository();
    private final ScoreRepository scoreRepository;

    //게임 룸을 초기화하고 저장함.
    public Room saveRoom() {
        ProgramBallDto dto = createProgramInput();
        String balls = dto.getBalls();
        ArrayList<Ball> listOfBalls = dto.getBallList();

        Room room = new Room();
        room.setCorrectBalls(balls);
        room.setBallList(listOfBalls);
        gameRepository.save(room);

        return room;
    }

    /*
    룸이 열려있는지 확인 전에, roomId 가 존재하는지 확인 -> 존재하지 않으면 InvalidInputException
    룸이 열려있다면 여부 반환
    */
    public Boolean validateRoomAlive(Long roomId) {
        validateRoomExists(roomId);
        Boolean gameOpen = gameRepository.findById(roomId).get().getGameStatus();
        return gameOpen;
    }

    //RoomExists 부분 예외처리 아직 안됨.
    public Room validateRoomExists(Long roomId) {
        Optional<Room> room = gameRepository.findById(roomId);
        return gameRepository.findById(roomId)
                .orElseThrow(() -> new InvalidInputException("존재하지 않는 roomId입니다"));
    }

    /*
    String input을 Ball로 변환하는 메서드 (Room 에서 프로그램이 생성 / user 가 생성 둘다)
    입력: String
    반환: ArrayList<Ball>
     */

    public ArrayList<Ball> convertToBallType(String answer) {
        ArrayList<Ball> playerBalls = new ArrayList<>();

        for (int i = 0; i < answer.length(); i++) {
            Ball ball = new Ball(answer.charAt(i), i);
            playerBalls.add(ball);
        }

        return playerBalls;
    }

    public ProgramBallDto createProgramInput() {
        //숫자3자리 볼을 만들고 String 으로 변환해서 convertToBallType에 넣기.
        ArrayList<Ball> programBalls = new ArrayList<>();
        StringBuilder correctBalls = new StringBuilder();
        //준비 - 프로그램이 난수 3개를 만든다.
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int min = 1;
        int max = 9;
        for (int i = 0; i < 3; i++) {
            int num = ((int) (Math.random() * (max - min + 1)) + 1);
            char charNum = (char) (num + '0'); //'0'대신
            Ball ball = new Ball(charNum, i);
            programBalls.add(ball);
            correctBalls.append(charNum);
        }
        ProgramBallDto dto = new ProgramBallDto(correctBalls.toString(), programBalls);
        return dto;
    }

    public GameNotAvailableDto gameIsNotAvailable() {
        ErrorCode error = new ErrorCode("CLOSED_GAME", "이미 종료된 게임입니다");
        GameNotAvailableDto dto = new GameNotAvailableDto(error);
        return dto;
    }

    public GameResultDto getResult(Long roomId) {
        Room room = gameRepository.findById(roomId).get();
        GameResultDto dto = new GameResultDto(room.getRemainingCount(), room.getAnsweredCount());
        return dto;
    }

    public HistoryDto getHistories(Long roomId) {
        List<Score> history = scoreRepository.findAll(roomId);
        HistoryDto dto = new HistoryDto(history);
        return dto;
    }

}