package tictactoe.model;

import tictactoe.component.CellNumberConverter;
import tictactoe.component.ComputerMove;
import tictactoe.component.Move;
import tictactoe.component.UserMove;

public enum PlayerType {
    USER,
    COMPUTER;

    public Move getMove(CellNumberConverter cellNumberConverter) {
        if (this == USER) {
            return new UserMove(cellNumberConverter);
        } else if (this == COMPUTER) {
            return new ComputerMove();
        }
        return null;
    }
}
