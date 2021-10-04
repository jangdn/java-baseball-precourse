package baseball;

import nextstep.utils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Answers {
    private List<Integer> values;

    private Answers(List<Integer> values) {
        this.values = values;
    }

    public static Answers createAnswer(){
        // TODO random 로직 추가
        return new Answers(new ArrayList<>());
    }
}
