package baseball;

import java.util.List;

public class GameService {
    private static class SingleGameService {
        private static final GameService gameService = new GameService();
    }

    public static GameService getInstance() {
        return SingleGameService.gameService;
    }

    public void play(GameServiceTool gameServiceTool) {
        Game game = Game.createNewGame();

        do {
            List<Integer> guesses = gameServiceTool.askAnswers();

            List<GameResult> gameResults = game.judge(guesses);

            GameHint hint = GameHint.createHintBy(gameResults);
            hint.printHint();

            game.allMatchAnswers(gameResults);

        } while (!game.isEnd());

        GameMessage.GAME_END.print();
    }
}
