package baseball.domain;

import baseball.common.Constants;

import java.util.List;

public class BaseBallGame {
    private List<Ball> balls;
    private BallCount ballCount;

    public BaseBallGame(List<Ball> balls, BallCount ballCount) {
        this.balls = balls;
        this.ballCount = ballCount;
    }

    public boolean isAnswer() {
        if (ballCount.getStrike() == Constants.MAX_STRIKE) {
            return true;
        }
        return false;
    }

    public String getStatus() {
        String message = "";
        if (isNothing()) message = Constants.NOTING;
        if (isBallOnly()) message = ballCount.getBall() + Constants.BALL;
        if (isStrikeOnly()) message = ballCount.getStrike() + Constants.STRIKE;
        if (isBallAndStrike()) message = ballCount.getBall() + Constants.BALL + " " + ballCount.getStrike() + Constants.STRIKE;
        return message;
    }

    public boolean isBallAndStrike() {
        if (ballCount.getBall() > 0 && ballCount.getStrike() > 0) {
            return true;
        }
        return false;
    }

    public boolean isStrikeOnly() {
        if (ballCount.getBall() == 0 && ballCount.getStrike() > 0) {
            return true;
        }
        return false;
    }

    public boolean isBallOnly() {
        if (ballCount.getBall() > 0 && ballCount.getStrike() == 0) {
            return true;
        }
        return false;
    }

    public boolean isNothing() {
        if (ballCount.getBall() == 0 && ballCount.getStrike() == 0) {
            return true;
        }
        return false;
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
