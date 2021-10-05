package baseball;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    public static boolean isEmpty(String input){
        return input == null || input.length() == 0;
    }

    public static List<Integer> toIntegers(List<String> strings){
        List<Integer> results = new ArrayList<>();
        for (String str : strings){
            results.add(Integer.parseInt(str));
        }
        return results;
    }
}
