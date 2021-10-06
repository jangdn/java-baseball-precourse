package baseball;

import baseball.game.GameService;
import baseball.game.tool.GameServiceTool;
import baseball.game.tool.GameServiceToolImpl;

public class Application {
	public static void main(String[] args) {
		GameServiceTool gameServiceTool = new GameServiceToolImpl();
		do {
			GameService gameService = GameService.getInstance();
			gameService.play(gameServiceTool);
		} while (gameServiceTool.askRestart());

	}
}
