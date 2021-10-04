package baseball;

import java.util.List;

public class Game {

    private Answers answers;

    private Boolean isEnd;

    private Game(Answers answers) {
        this.answers = answers;
    }

    public static Game createNewGame() {
        Answers answer = Answers.createAnswer();
        return new Game(answer);
    }

    public List<GameResult> judge(List<Integer> answer) {
        // TODO judge 시 게임이 끝났는지 확인하는 로직 추가
        this.isEnd = false;
        return null;
    }

    public boolean isEnd() {
        return false;
    }
}
