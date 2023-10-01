package baseball.service;

import baseball.common.Constants;
import baseball.domain.Ball;
import baseball.domain.BallCount;
import baseball.domain.BaseBallGame;
import baseball.exception.CustomException;
import baseball.exception.ErrorCode;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class TestBaseballService {
    private BaseBallGame baseballGame;
    private BallCount ballCount;
    private List<Integer> computerNumbers;

    public boolean isRestartGame(String isRestart) {
        if (isRestart.equals(Constants.QUIT_GAME)) return false;
        if (isRestart.equals(Constants.RESTART_GAME)) return true;
        throw new CustomException(ErrorCode.INVALID_RESTART_NUMBER);
    }

    public BaseBallGame startingGame() {
        System.out.print("숫자를 입력해주세요 : ");
        ballCount = new BallCount();
        baseballGame = new BaseBallGame(userInput(readLine()), ballCount);
        play(computerNumbers);
        return baseballGame;
    }

    public void play(List<Integer> computer) {
        for (int i = 0; i < Constants.BALLS_LENGTH; i++) {
            for (int j = 0; j < Constants.BALLS_LENGTH; j++) {
                isBall(i, j, computer, baseballGame.getBalls());
                isStrike(i, j, computer, baseballGame.getBalls());
            }
        }
    }

    public void isBall(int idx, int idx2, List<Integer> computer, List<Ball> user) {
        if ((idx != idx2) && (computer.get(idx) == user.get(idx2).getNumber())) {
            ballCount.incrementBall();
        }
    }

    public void isStrike(int idx, int idx2, List<Integer> computer, List<Ball> user) {
        if ((idx == idx2) && (computer.get(idx) == user.get(idx2).getNumber())) {
            ballCount.incrementStrike();
        }
    }


    public List<Ball> userInput(String input) {
        return Arrays.stream(input.split("")).map(toBall()).collect(Collectors.toList());
    }

    public Function<String, Ball> toBall() {
        return digit -> new Ball(Integer.parseInt(digit));
    }


    public void validateOfDuplicate(String number) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < Constants.BALLS_LENGTH; i++) {
            set.add(String.valueOf(number.charAt(i)));
        }

        if (set.size() != Constants.BALLS_LENGTH) {
            throw new IllegalArgumentException(ErrorCode.INVALID_INPUT_DUPLICATE.getMessage());
        }
    }

    public void validateOfInputLength(String number) {
        if (number.length() != Constants.BALLS_LENGTH) {
            throw new IllegalArgumentException(ErrorCode.INVALID_INPUT_LENGTH.getMessage());
        }
    }

    public void settingGame() {
        computerInput();
    }

    public List<Integer> computerInput() {
        computerNumbers = new ArrayList<>();
        while (computerNumbers.size() != Constants.BALLS_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(Constants.MIN_BALL_NUMBER, Constants.MAX_BALL_NUMBER);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return Randoms.shuffle(computerNumbers);
    }
}
