package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        do {
            GameService gameService = GameService.getInstance();
            gameService.play();
        } while (GameServiceUtil.askRestart());

    }
}
