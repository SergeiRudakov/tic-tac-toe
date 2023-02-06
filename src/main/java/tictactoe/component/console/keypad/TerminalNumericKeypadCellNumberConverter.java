package tictactoe.component.console.keypad;

import tictactoe.component.console.CellNumberConverter;
import tictactoe.model.game.Cell;

public class TerminalNumericKeypadCellNumberConverter implements CellNumberConverter {

    @Override
    public Cell toCell(final char numberOfCell) {
        final int val = numberOfCell - '0' - 1;
        return new Cell(val / 3, val % 3);
    }

    @Override
    public char toNumber(final Cell cell) {
        return (char) ('0' + (cell.getRow() * 3) + cell.getCol() + 1);
    }
}
