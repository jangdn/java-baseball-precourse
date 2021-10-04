package baseball;

import lombok.Getter;

@Getter
public enum GameResult {
    STRIKE("스트라이크"),
    BALL("볼");

    private final String description;

    GameResult(String description) {
        this.description = description;
    }
}
