package baseball;

import java.util.List;

public class Game {

    private Answers answers;

    private Boolean end;

    private Game(Answers answers, boolean end) {
        this.answers = answers;
        this.end = end;
    }

    public static Game createNewGame() {
        Answers answers = Answers.createAnswer();
        return new Game(answers, false);
    }

    public List<GameResult> judge(List<Integer> guesses) {
        return this.answers.judgeResults(guesses);
    }

    public void allMatchAnswers(List<GameResult> gameResults) {
        for (GameResult gameResult : gameResults) {
            if(gameResult.equals(GameResult.BALL)) {
                this.end = false;
                return ;
            }
        }
        this.end = true;
    }

    public Boolean isEnd() {
        return this.end;
    }
}
