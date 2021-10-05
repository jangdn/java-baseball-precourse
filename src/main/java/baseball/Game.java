package baseball;

import lombok.Getter;

import java.util.List;

public class Game {

    private static final int GAME_ANSWER_SIZE = 3;

    private Answers answers;

    private Boolean end;

    private Game(Answers answers, boolean end) {
        this.answers = answers;
        this.end = end;
    }

    public static Game createNewGame() {
        Answers answers = Answers.createAnswer(GAME_ANSWER_SIZE);
        return new Game(answers, false);
    }

    public List<GameResult> judge(List<Integer> answer) {
        // TODO judge 시 게임이 끝났는지 확인하는 로직 추가
        this.end = false;
        return null;
    }

    public Boolean isEnd() {
        return this.end;
    }
}
