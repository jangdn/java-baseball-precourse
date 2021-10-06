package baseball.game.tool;

import baseball.game.GameMessage;

import java.util.function.Function;

public class ConsoleInput {
    private String input;

    public String getInput() {
        return input;
    }

    public boolean isValid() {
        return isValid;
    }

    private boolean isValid;

    public ConsoleInput(String input, boolean isValid) {
        this.input = input;
        this.isValid = isValid;
    }

    public ConsoleInput() {
    }

    public void validate(Function<String, Boolean> function) {
        this.isValid = function.apply(this.input);
    }

    public void inValidationMessage(GameMessage invalidInputString) {
        if(!this.isValid){
            invalidInputString.print();
        }
    }
}
