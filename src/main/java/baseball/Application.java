package baseball;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        // TODO: 프로그램 구현
        BaseballController baseballController = new BaseballController(new BaseballService());
        baseballController.startGame();
    }
}
