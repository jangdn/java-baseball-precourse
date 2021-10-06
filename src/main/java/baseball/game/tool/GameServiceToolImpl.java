package baseball.game.tool;

import java.util.Arrays;
import java.util.List;

import baseball.game.GameMessage;
import baseball.util.StringUtil;
import nextstep.utils.Console;

public class GameServiceToolImpl implements GameServiceTool {

	private static final String RESTART_SIGNAL = "1";
	private static final String END_SIGNAL = "2";

	private static final String NUMBER_REGEX = "[1-9]+";

	@Override
	public boolean askRestart() {
		GameMessage.DO_TOU_RESTART_GAME.print(RESTART_SIGNAL, END_SIGNAL);

		ConsoleInput consoleInput = null;
		do {
			consoleInput = new ConsoleInput(Console.readLine(), false);
			consoleInput.validate(GameServiceToolImpl::validateRestart);
			consoleInput.inValidationMessage(GameMessage.INVALID_INPUT_STRING);
		} while(!consoleInput.isValid());

		if (consoleInput.getInput().equals(RESTART_SIGNAL)){
			return true;
		}

		return false;
	}

	private static Boolean validateRestart(String input) {
		if (input.equals(RESTART_SIGNAL)) {
			return true;
		}

		if (input.equals(END_SIGNAL)) {
			return true;
		}

		return false;
	}

	@Override
	public List<Integer> askAnswers() {
		GameMessage.ENTER_GUESS_ANSWER.print();

		ConsoleInput consoleInput = null;
		do {
			consoleInput = new ConsoleInput(Console.readLine(), false);
			consoleInput.validate(GameServiceToolImpl::validateAnswers);
			consoleInput.inValidationMessage(GameMessage.INVALID_INPUT_STRING);
		} while(!consoleInput.isValid());

		String[] inputGuessesSplit = consoleInput.getInput().split("");

		return StringUtil.toIntegers(Arrays.asList(inputGuessesSplit));
	}

	private static boolean validateAnswers(String inputGuess) {
		if (StringUtil.isEmpty(inputGuess)) {
			return false;
		}

		if (!inputGuess.matches(NUMBER_REGEX)) {
			return false;
		}

		return !StringUtil.isDuplicateIn(inputGuess);
	}
}
