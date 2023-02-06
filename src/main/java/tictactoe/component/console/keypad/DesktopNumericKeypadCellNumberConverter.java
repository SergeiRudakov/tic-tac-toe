package tictactoe.component.console.keypad;

import tictactoe.component.console.CellNumberConverter;
import tictactoe.model.game.Cell;

public class DesktopNumericKeypadCellNumberConverter implements CellNumberConverter {

    private final char[][] mapping = {
            {'7', '8', '9'},
            {'4', '5', '6'},
            {'1', '2', '3'}
    };

    @Override
    public Cell toCell(final char numberOfCell) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mapping[i][j] == numberOfCell) {
                    return new Cell(i, j);
                }
            }
        }
        return null;
    }

    @Override
    public char toNumber(final Cell cell) {
        return mapping[cell.getRow()][cell.getCol()];
    }
}
