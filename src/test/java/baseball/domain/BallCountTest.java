package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallCountTest {

    BallCount ballCount;

    @BeforeEach
    void setup() {
        ballCount = new BallCount();
    }

    @Test
    void 볼_카운트는_0_이다() {
        assertThat(ballCount.getBall()).isEqualTo(0);
    }

    @Test
    void 스트라이크_카운트는_0_이다() {
        assertThat(ballCount.getStrike()).isEqualTo(0);
    }

    @Test
    void 볼_1개_증가시킨다() {
        ballCount.incrementBall();
        assertThat(ballCount.getBall()).isEqualTo(1);
    }

    @Test
    void 스트라이크_1개_증가시킨다() {
        ballCount.incrementStrike();
        assertThat(ballCount.getStrike()).isEqualTo(1);
    }
}