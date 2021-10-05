package baseball;

import java.util.List;

public class GameHint {
    private List<GameResult> gameResults;

    private Integer strikeCount = 0;
    private Integer ballCount = 0;
    private Integer missCount = 0;

    public Integer getStrikeCount() {
        return strikeCount;
    }

    public Integer getBallCount() {
        return ballCount;
    }

    public Integer getMissCount() {
        return missCount;
    }

    private GameHint(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public static GameHint createHintBy(List<GameResult> gameResults){
        GameHint gameHint = new GameHint(gameResults);
        gameHint.calculateCount();
        return gameHint;
    }

    private void calculateCount() {
        for (GameResult gameResult : this.gameResults) {
            increaseCount(gameResult);
        }
    }

    private void increaseCount(GameResult gameResult) {
        if(gameResult.equals(GameResult.STRIKE)){
            strikeCount++;
            return ;
        }
        if(gameResult.equals(GameResult.BALL)){
            ballCount++;
            return ;
        }
        missCount++;
    }

    public void printHint() {
        if(strikeCount != 0) {
            GameMessage.GAME_RESULT_STRIKE.print(String.valueOf(strikeCount));
        }
        if(ballCount != 0) {
            GameMessage.GAME_RESULT_BALL.print(String.valueOf(strikeCount));
        }
        if(strikeCount == 0 && ballCount == 0) {
            GameMessage.GAME_RESULT_NOTHING.print();
        }
    }
}
