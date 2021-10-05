package baseball;

public class Application {
    public static void main(String[] args) {
        GameServiceTool gameServiceTool = new GameServiceToolImpl();
        do {
            GameService gameService = GameService.getInstance();
            gameService.play(gameServiceTool);
        } while (gameServiceTool.askRestart());

    }
}
