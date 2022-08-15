package com.example.BaseballGame.service;

import com.example.BaseballGame.domain.Ball;
import com.example.BaseballGame.domain.Result;
import com.example.BaseballGame.domain.Room;
import com.example.BaseballGame.domain.Score;
import com.example.BaseballGame.dto.ScoreDto;
import com.example.BaseballGame.repository.GameRepository;
import com.example.BaseballGame.repository.ScoreMemoryRepository;
import com.example.BaseballGame.repository.ScoreRepository;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ScoreService {

    private final GameService gameService;
    private final GameRepository gameRepository;
    private final ScoreRepository scoreRepository = new ScoreMemoryRepository();

    public ScoreDto scoreBalls(String userBalls, Long roomId) {
        //userBalls를 Ball 형태로 변환해서 채점할 수 있게 준비.
        ArrayList<Ball> balls = gameService.convertToBallType(userBalls);
        //roomId 에서 programBalls를 가져오기.
        ArrayList<Ball> programBalls = gameRepository.findById(roomId).get().getBallList();
        ArrayList<Character> strikeList = new ArrayList<>(); //
        ArrayList<Ball> scoreBallList = new ArrayList<>();

        //Strike 찾기 Equals 는 주소값이 다른 객체는 서로 다른 객체로 판단한다. 따라서 equals 메서드 재정의 필요.
        for (int i = 0; i < balls.size(); i++) {
            Ball temp = balls.get(i); //user의 볼 객체로 이루어진 리스트를 조회하며 비교한다.
            Ball programTemp = programBalls.get(i);
            if (temp.equals(programTemp)) {
                    strikeList.add(temp.getNum());
            }
        }

        // Ball 찾기
        for (int i = 0; i < balls.size(); i++) {
            for(Ball ball : balls) {
                    if ((ball.getNum() == programBalls.get(i).getNum())&&(ball.getIndex()!=programBalls.get(i).getIndex())) {
                        if(!strikeList.contains(ball.getNum())) {
                            scoreBallList.add(ball); //strikeList에 해당 객체가 포함되어 있지 않을 때만, ball 로 간주
                        }
                    }
            }
        }

        //점수를 Result에 담아서 반환한다.
        int strike = strikeList.size();
        int scoreBall = scoreBallList.size(); //위치가 같지 않아도 숫자는 같은 경우.
        int nothing = 3-strike-scoreBall;

        Result result = new Result(strike, scoreBall, nothing);

        //gameScore가 한 번 진행될 때, remainingCount가 줄어든다.
        Room room = gameRepository.findById(roomId).get();
        room.changeGameCount(roomId);

        //scoreRepository에 result를 저장한다. roomId도 함께 매핑.
        Score score = new Score(userBalls, result);
        scoreRepository.save(roomId, score);
        //roomId 기준으로 찾아서 histories 가져오기.

        //10번의 게임을 진행했거나, 스트라이크가 3개라면 게임이 닫힌다.
        if(result.getStrike() == 3) {
            room.setCorrect(true);
        }
        if(room.getRemainingCount()==0 || room.isCorrect()) {
            room.setGameStatus(false);
        }

        ScoreDto scoreDto = new ScoreDto(room.isCorrect(), room.getRemainingCount(), strike, scoreBall, nothing);
        return scoreDto;
    }
}
