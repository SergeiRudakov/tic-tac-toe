package tictactoe.model.config;

import tictactoe.component.DataPrinter;
import tictactoe.component.*;

public enum PlayerType {
    USER,
    COMPUTER;

    public Move getMove(UserInputReader userInputReader, DataPrinter dataPrinter) {
        if (this == USER) {
            return new UserMove(userInputReader, dataPrinter);
        } else if (this == COMPUTER) {
            return new ComputerMove();
        }
        return null;
    }
}
