package tictactoe;

import tictactoe.component.*;
import tictactoe.keypad.DesktopNumericKeypadCellNumberConverter;
import tictactoe.model.Player;
import tictactoe.model.Sign;
//import tictactoe.keypad.TerminalNumericKeypadCellNumberConverter;

public class Launcher {
    public static void main(final String[] args) {
        final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
        final Game game = new Game(
                new DataPrinter(cellNumberConverter),
                new Player(Sign.X, new UserMove(cellNumberConverter)),
                new Player(Sign.O, new ComputerMove()),
                new WinnerVerifier(),
                new CellVerifier(),
                false);
        game.play();
    }
}
