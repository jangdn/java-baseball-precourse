package baseball;

import nextstep.utils.Console;

import java.util.Arrays;
import java.util.List;

public class GameServiceToolImpl implements GameServiceTool {

    private final static String RESTART_SIGNAL = "1";
    private final static String END_SIGNAL = "2";

    private final static String NUMBER_REGEX = "[1-9]+";

    @Override
    public boolean askRestart() {
        GameMessage.DO_TOU_RESTART_GAME.print(RESTART_SIGNAL, END_SIGNAL);

        String input = Console.readLine();

        if (input.equals(RESTART_SIGNAL))
            return true;

        if (input.equals(END_SIGNAL))
            return false;

        throw new IllegalArgumentException(GameMessage.INVALID_INPUT_STRING.getMessage());
    }

    @Override
    public List<Integer> askAnswers() {
        GameMessage.ENTER_GUESS_ANSWER.print();

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
            GameMessage.INVALID_INPUT_STRING.print();
        }
    }

    private static boolean validateInput(String inputGuess) {
        if(StringUtil.isEmpty(inputGuess))
            return false;

        return inputGuess.matches(NUMBER_REGEX);
    }
}
