package baseball.game;

public enum GameMessage {
	DO_TOU_RESTART_GAME("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요."),

	ENTER_GUESS_ANSWER("숫자를 입력해주세요 : "),

	GAME_RESULT_STRIKE("%s스트라이크 "),
	GAME_RESULT_BALL("%s볼 "),
	GAME_RESULT_NOTHING("낫싱 "),

	GAME_END("게임 끝"),

	INVALID_INPUT_STRING("[ERROR] 잘못된 입력값입니다.");

	private final String messageForm;

	public void print(String... strs){
		System.out.printf(messageForm, (Object[]) strs);
	}

	GameMessage(String messageForm) {
		this.messageForm = messageForm;
	}

	public String getMessage() {
		return this.messageForm;
	}
}
