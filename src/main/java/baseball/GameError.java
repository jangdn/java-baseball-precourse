package baseball;


public enum GameError {
    INVALID_INPUT_STRING("[ERROR] 잘못된 input입니다.");

    private final String description;

    public String getDescription(){
        return this.description;
    }

    GameError(String description) {
        this.description = description;
    }
}
