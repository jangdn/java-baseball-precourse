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

        System.out.print("게임 끝");
    }


    private void printGameResult(List<GameResult> gameResults) {
        int strikeCount = countResult(gameResults, GameResult.STRIKE);
        int ballCount = countResult(gameResults, GameResult.BALL);

        StringBuilder builder = new StringBuilder();

        if(strikeCount != 0) {
            builder.append(String.format("%d스트라이크 ", strikeCount));
        }
        if(ballCount != 0){
            builder.append(String.format("%d볼", ballCount));
        }

        if(builder.length() == 0){
            builder.append("낫싱");
        }
        System.out.print(builder.toString());
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
