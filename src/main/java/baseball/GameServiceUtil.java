package baseball;

import nextstep.utils.Console;

public class GameServiceUtil {

    private final static String RESTART_SIGNAL = "1";
    private final static String END_SIGNAL = "2";

    public static boolean askRestart() {

        System.out.print("게임을 새로 시작하려면 "+RESTART_SIGNAL+", 종료하려면 "+ END_SIGNAL +"를 입력하세요.");

        String input = Console.readLine();

        if (input.equals(RESTART_SIGNAL))
            return true;

        if (input.equals(END_SIGNAL))
            return false;

        throw new IllegalArgumentException(GameError.INVALID_INPUT_STRING.getDescription());
    }
}
