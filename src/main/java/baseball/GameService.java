package baseball;

import java.util.List;

public class GameService {
    private static class SingleGameService {
        private static final GameService gameService = new GameService();
    }

    public static GameService getInstance() {
        return SingleGameService.gameService;
    }

    public void play() {
        Game game = Game.createNewGame();

        do {
            List<Integer> answers = askAnswers();

            List<GameResult> gameResults = game.judge(answers);

            printGameResult(gameResults);

        } while (game.isEnd());


    }

    private void printGameResult(List<GameResult> gameResults) {
        // TODO Game Result print 할 부분
        System.out.print("result");
    }

    private List<Integer> askAnswers() {
        return null;
    }

    private Game createAnswerNumbers() {
        return null;
    }
}
