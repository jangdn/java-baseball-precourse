package baseball.util;

import java.util.*;

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

    public static boolean isDuplicateIn(String strings) {
        char[] charArray = strings.toCharArray();
        Set<Character> charSet = new HashSet<>();
        for (char element : charArray) {
            charSet.add(element);
        }
        return charSet.size() != charArray.length;
    }
}
