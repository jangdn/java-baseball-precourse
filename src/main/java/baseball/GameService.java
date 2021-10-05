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

            printGameResult(gameResults);

            game.allMatchAnswers(gameResults);

        } while (!game.isEnd());

        GameMessage.GAME_END.print();
    }


    private void printGameResult(List<GameResult> gameResults) {
        int strikeCount = countResult(gameResults, GameResult.STRIKE);
        int ballCount = countResult(gameResults, GameResult.BALL);

        if(strikeCount != 0) {
            GameMessage.GAME_RESULT_STRIKE.print(String.valueOf(strikeCount));
        }
        if(ballCount != 0){
            GameMessage.GAME_RESULT_BALL.print(String.valueOf(strikeCount));
        }
        if(strikeCount == 0 && ballCount == 0){
            GameMessage.GAME_RESULT_NOTHING.print();
        }
    }

    private int countResult(List<GameResult> gameResults, GameResult countType) {
        int count = 0;
        for (GameResult gameResult : gameResults) {
            count += equalGameResult(countType, gameResult);
        }
        return count;
    }

    private int equalGameResult(GameResult countType, GameResult gameResult) {
        if(gameResult.equals(countType))
            return 1;
        return 0;
    }

}
