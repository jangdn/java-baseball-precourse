package baseball.game;

import baseball.game.domain.Game;
import baseball.game.domain.GameHint;
import baseball.game.domain.GameResult;
import baseball.game.tool.GameServiceTool;

import java.util.List;

public class GameService {
    private static class SingleGameService {
        private static final GameService gameService = new GameService();
    }

    public static GameService getInstance() {
        return SingleGameService.gameService;
    }

    public void play(GameServiceTool gameServiceTool) {
        Game game = Game.createGame();

        do {
            List<Integer> guesses = gameServiceTool.askAnswers();

            List<GameResult> gameResults = game.judge(guesses);

            GameHint hint = GameHint.createBy(gameResults);
            hint.printHint();

            game.judgeEnd(gameResults);

        } while (!game.isEnd());

        GameMessage.GAME_END.print();
    }
}
