package baseball;

import nextstep.utils.Console;

public class GameServiceUtil {

    private final static String RESTART_SIGNAL = "OK";
    private final static String END_SIGNAL = "END";

    public static boolean askRestart() {

        System.out.print("게임을 계속 하시겠습니까? ( "+ RESTART_SIGNAL + "/" + END_SIGNAL +" )");

        String input = Console.readLine();

        if (input.equals(RESTART_SIGNAL))
            return true;

        if (input.equals(END_SIGNAL))
            return false;

        throw new IllegalArgumentException(GameError.INVALID_INPUT_STRING.getDescription());
    }
}
