package tictactoe.component;

import tictactoe.model.Cell;

public interface CellNumberConverter {

    Cell toCell(char numberOfCell);

    char toNumber(Cell cell);

}
