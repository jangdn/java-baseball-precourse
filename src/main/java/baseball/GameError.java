package baseball;

import lombok.Getter;

@Getter
public enum GameError {
    INVALID_INPUT_STRING("Not Valid Input String");

    private final String description;

    GameError(String description) {
        this.description = description;
    }
}
