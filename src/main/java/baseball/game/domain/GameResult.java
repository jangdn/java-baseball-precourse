package baseball.game.domain;

public enum GameResult {
    STRIKE("스트라이크"),
    BALL("볼"),
    MISS("미스");

    private final String description;

    public String getDescription(){
        return this.description;
    }

    GameResult(String description) {
        this.description = description;
    }
}
