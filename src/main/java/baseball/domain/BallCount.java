package baseball.domain;

public class BallCount {
    private int ball;
    private int strike;

    public BallCount() {
        this.ball = 0;
        this.strike = 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void incrementBall() {
        ball++;
    }

    public void incrementStrike() {
        strike++;
    }
}
