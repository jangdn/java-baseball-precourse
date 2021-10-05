package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Answers {
    private static final int RESTRICT_START_NUM = 1;
    private static final int RESTRICT_END_NUM = 9;

    public static final int GAME_ANSWER_SIZE = 3;

    private List<Integer> values;

    private Answers(List<Integer> values) {
        this.values = values;
    }

    public static Answers createAnswer(){
        ArrayList<Integer> answers = new ArrayList<>(GAME_ANSWER_SIZE);
        for (int idx = 0 ; idx < GAME_ANSWER_SIZE ; idx++){
            answers.add(Randoms.pickNumberInRange(RESTRICT_START_NUM, RESTRICT_END_NUM));
        }

        return new Answers(answers);
    }

    public List<GameResult> judgeResults(List<Integer> guesses) {
        List<GameResult> resultSet = new ArrayList<>(GAME_ANSWER_SIZE);
        for (int idx = 0; idx<GAME_ANSWER_SIZE ; idx++) {
            resultSet.add(showResult(idx, guesses.get(idx)));
        }
        return resultSet;
    }

    private GameResult showResult(Integer idx, Integer guess) {
        if(values.get(idx).equals(guess))
            return GameResult.STRIKE;
        if(values.contains(guess))
            return GameResult.BALL;

        return GameResult.MISS;
    }
}
