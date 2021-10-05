package baseball;

import nextstep.utils.Console;

public class AskUtil {
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
        if(inCorrectInput)
            System.out.println("[ERROR] 잘못된 input입니다.");
    }

    private static boolean validateInput(String inputGuess) {
        if(StringUtil.isEmpty(inputGuess))
            return false;

        return inputGuess.matches("[0-9]+");
    }
}
