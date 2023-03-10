package tictactoe.component;

import tictactoe.model.game.Cell;
import tictactoe.model.game.GameTable;
import tictactoe.model.game.Sign;

public class UserMove implements Move {

    private final DataPrinter dataPrinter;
    private final UserInputReader userInputReader;

    public UserMove(UserInputReader userInputReader, final DataPrinter dataPrinter)
    {
        this.userInputReader = userInputReader;
        this.dataPrinter = dataPrinter;
    }

    @Override
    public void make(final GameTable gameTable, Sign sign) {
        while (true) {
            final Cell cell = userInputReader.getUserInput();
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, sign);
                return;
            } else {
                dataPrinter.printErrorMessage("Can't make a move, because the cell is not free! Try again!");
            }
        }
    }
}
