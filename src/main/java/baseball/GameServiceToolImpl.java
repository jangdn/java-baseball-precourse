package baseball;

import nextstep.utils.Console;

import java.util.Arrays;
import java.util.List;

import static baseball.GameError.INVALID_INPUT_STRING;

public class GameServiceToolImpl implements GameServiceTool {

    private final static String RESTART_SIGNAL = "1";
    private final static String END_SIGNAL = "2";

    private final static String NUMBER_REGEX = "[1-9]+";

    @Override
    public boolean askRestart() {
        System.out.print("게임을 새로 시작하려면 "+RESTART_SIGNAL+", 종료하려면 "+ END_SIGNAL +"를 입력하세요.");

        String input = Console.readLine();

        if (input.equals(RESTART_SIGNAL))
            return true;

        if (input.equals(END_SIGNAL))
            return false;

        throw new IllegalArgumentException(INVALID_INPUT_STRING.getDescription());
    }

    @Override
    public List<Integer> askAnswers() {

        String guessStr = "";
        boolean inCorrectInput = true;
        while(inCorrectInput) {
            guessStr = Console.readLine();
            inCorrectInput = !validateInput(guessStr);
            printInCorrectInput(inCorrectInput);
        }

        String[] inputGuesses = guessStr.split("");

        return StringUtil.toIntegers(Arrays.asList(inputGuesses));
    }

    private static void printInCorrectInput(boolean inCorrectInput) {
        if(inCorrectInput) {
            System.out.print(INVALID_INPUT_STRING.getDescription());
        }
    }

    private static boolean validateInput(String inputGuess) {
        if(StringUtil.isEmpty(inputGuess))
            return false;

        return inputGuess.matches(NUMBER_REGEX);
    }
}
