package tictactoe.component.console;

import tictactoe.model.game.Cell;

public interface CellNumberConverter {

    Cell toCell(char numberOfCell);

    char toNumber(Cell cell);

}
