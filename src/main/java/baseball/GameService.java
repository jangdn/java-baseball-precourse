package baseball;

public class GameService {


    private static class SingleGameService {
        private static final GameService gameService = new GameService();
    }

    public static GameService getInstance() {
        return SingleGameService.gameService;
    }

    public void play() {

    }
}
