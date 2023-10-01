package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

    @Test
    void 볼_생성() {
        int input = 1;

        assertThat(new Ball(input).getNumber()).isEqualTo(1);
    }

    @Test
    void 볼_생성시_범위에_벗어난_숫자_예외_발생() {
        int input = 11;

        assertThatThrownBy(() -> new Ball(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 1~9 사이의 숫자이어야 합니다.");
    }
}