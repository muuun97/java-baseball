package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallGameTest {

    @Test
    void 사용자_볼을_가져온다() {
        BallCount ballCount = new BallCount();
        BaseBallGame baseBallGame = new BaseBallGame(List.of(new Ball(1)), ballCount);

        assertThat(baseBallGame.getBalls().get(0).getNumber()).isEqualTo(1);
        assertThat(baseBallGame.getBalls().get(0)).isNotEqualTo(new Ball(1));
    }

    @Test
    void 볼_반환() {
        BallCount ballCount = new BallCount();
        ballCount.incrementBall();
        BaseBallGame baseBallGame = new BaseBallGame(List.of(new Ball(1)), ballCount);

        String message = "1볼";
        assertThat(baseBallGame.isBallOnly()).isTrue();
        assertThat(baseBallGame.getStatus()).isEqualTo(message);
    }

    @Test
    void 스트라이크_반환() {
        BallCount ballCount = new BallCount();
        ballCount.incrementStrike();
        BaseBallGame baseBallGame = new BaseBallGame(List.of(new Ball(1)), ballCount);

        String message = "1스트라이크";
        assertThat(baseBallGame.isStrikeOnly()).isTrue();
        assertThat(baseBallGame.getStatus()).isEqualTo(message);
    }

    @Test
    void 볼_스트라이크_반환() {
        BallCount ballCount = new BallCount();
        ballCount.incrementBall();
        ballCount.incrementStrike();
        BaseBallGame baseBallGame = new BaseBallGame(List.of(new Ball(1)), ballCount);

        String message = "1볼 1스트라이크";
        assertThat(baseBallGame.isBallAndStrike()).isTrue();
        assertThat(baseBallGame.getStatus()).isEqualTo(message);
    }

    @Test
    void 낫싱_반환() {
        BallCount ballCount = new BallCount();
        BaseBallGame baseBallGame = new BaseBallGame(List.of(new Ball(1)), ballCount);

        String message = "낫싱";
        assertThat(baseBallGame.isNothing()).isTrue();
        assertThat(baseBallGame.getStatus()).isEqualTo(message);
    }
}