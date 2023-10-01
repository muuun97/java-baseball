package baseball.domain;

import baseball.common.Constants;
import baseball.exception.ErrorCode;

import java.util.Objects;

public class Ball {
    private int number;

    public Ball(int number) {
        validateOfNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateOfNumber(int number) {
        if (number < Constants.MIN_BALL_NUMBER || number > Constants.MAX_BALL_NUMBER) {
            throw new IllegalArgumentException(ErrorCode.INVALID_INPUT_NUMBER.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
