package baseball;

import nextstep.utils.Console;

import java.util.ArrayList;
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
        System.out.println("숫자를 입력해주세요 : ");
        String askAnswersStr = Console.readLine();

        // TODO validation 추가
        String[] inputAnswersArray = askAnswersStr.split("");
        ArrayList<Integer> inputAnswers = new ArrayList<>(inputAnswersArray.length);
        for (int idx = 0; idx < inputAnswersArray.length; idx++) {
            inputAnswers.add(Integer.parseInt(inputAnswersArray[idx]));
        }

        return inputAnswers;
    }

    private Game createAnswerNumbers() {
        return null;
    }
}
