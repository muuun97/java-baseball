package baseball.controller;

import baseball.domain.BaseBallGame;
import baseball.service.BaseballService;
import baseball.view.PrintView;

public class BaseballController {

    private final BaseballService baseballService;

    public BaseballController(BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    /*
    ep : 요구사항
        - 입력은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용
        - indent depth 는 2까지
        - 새로 시작과 종료
     */
    public void startGame() {
        baseballService.settingGame();
        PrintView.printStartGame();

        while (true) {
            BaseBallGame game = baseballService.startingGame();
            if (game.isAnswer()) {
                break;
            }
            PrintView.printGameStatus(game.getStatus());
        }

        PrintView.printGameOver();
        if (baseballService.isRestartGame()) {
            startGame();
        }
    }
}
