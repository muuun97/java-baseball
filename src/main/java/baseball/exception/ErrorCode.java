package baseball.exception;

public enum ErrorCode {
    INVALID_INPUT_NUMBER("입력값은 1~9 사이의 숫자이어야 합니다."),
    INVALID_INPUT_LENGTH("입력값의 길이는 3이어야 합니다."),
    INVALID_INPUT_DUPLICATE("입력값에 중복된 수가 존재합니다."),
    INVALID_RESTART_NUMBER("입력은 1 혹은 2만 가능합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
