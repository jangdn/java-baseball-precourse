package baseball;

import nextstep.utils.Console;

import static baseball.GameError.INVALID_INPUT_STRING;

public class GameServiceUtil {

    private final static String RESTART_SIGNAL = "1";
    private final static String END_SIGNAL = "2";

    private final static String NUMBER_REGEX = "[0-9]+";;

    public static boolean askRestart() {

        System.out.print("게임을 새로 시작하려면 "+RESTART_SIGNAL+", 종료하려면 "+ END_SIGNAL +"를 입력하세요.");

        String input = Console.readLine();

        if (input.equals(RESTART_SIGNAL))
            return true;

        if (input.equals(END_SIGNAL))
            return false;

        throw new IllegalArgumentException(INVALID_INPUT_STRING.getDescription());
    }


    public static String askAnswers() {
        String guessStr = "";
        boolean inCorrectInput = true;
        while(inCorrectInput) {
            guessStr = Console.readLine();
            inCorrectInput = !validateInput(guessStr);
            printInCorrectInput(inCorrectInput);
        }

        return guessStr;
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
