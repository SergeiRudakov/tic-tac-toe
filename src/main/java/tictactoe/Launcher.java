package tictactoe;

import tictactoe.component.*;
import tictactoe.keypad.DesktopNumericKeypadCellNumberConverter;
//import tictactoe.keypad.TerminalNumericKeypadCellNumberConverter;

public class Launcher {
    public static void main(final String[] args) {
        final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
        final Game game = new Game(
                new DataPrinter(cellNumberConverter),
                new ComputerMove(),
                new UserMove(cellNumberConverter),
                new WinnerVerifier(),
                new CellVerifier());
        game.play();
    }
}
