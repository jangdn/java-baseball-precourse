package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Answers {
    private static final int RESTRICT_START_NUM = 1;
    private static final int RESTRICT_END_NUM = 9;

    private List<Integer> values;

    private Answers(List<Integer> values) {
        this.values = values;
    }

    public static Answers createAnswer(int size){
        ArrayList<Integer> answers = new ArrayList<>(size);
        for (int idx = 0 ; idx < size ; idx++){
            answers.add(Randoms.pickNumberInRange(RESTRICT_START_NUM, RESTRICT_END_NUM));
        }

        return new Answers(answers);
    }
}
