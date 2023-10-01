package baseball.service;

import baseball.domain.Ball;
import baseball.domain.BallCount;
import baseball.domain.BaseBallGame;
import baseball.exception.CustomException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BaseballServiceTest {
    TestBaseballService service;

    @BeforeEach
    void setup() {
        service = new TestBaseballService();
    }

    @Test
    void 컴퓨터_랜덤_난수_생성한다() {
        List<Integer> computerNumbers = service.computerInput();
        assertThat(computerNumbers.size()).isEqualTo(3);
    }

    @Test
    void 사용자_숫자_길이_검증한다() {
        String input = "1234";
        assertThatThrownBy(() -> service.validateOfInputLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값의 길이는 3이어야 합니다.");
    }

    @Test
    void 사용자_숫자_중복_검증한다() {
        String input = "122";
        assertThatThrownBy(() -> service.validateOfDuplicate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값에 중복된 수가 존재합니다.");
    }

    @Test
    void 사용자_입력_리스트로_변환한다() {
        String input = "123";
        assertThat(service.userInput(input)).
                isEqualTo(List.of(new Ball(1), new Ball(2), new Ball(3)));
    }

    @Test
    void 재시작_여부_검증한다() {
        String restart = "1";
        String quit = "2";
        String exception = "3";

        assertThat(service.isRestartGame(restart)).isTrue();
        assertThat(service.isRestartGame(quit)).isFalse();
        assertThatThrownBy(() -> service.isRestartGame(exception))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining("입력은 1 혹은 2만 가능합니다.");
    }
}