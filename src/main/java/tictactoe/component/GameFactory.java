package tictactoe.component;

import tictactoe.keypad.DesktopNumericKeypadCellNumberConverter;
import tictactoe.model.Player;
import tictactoe.model.PlayerType;
import tictactoe.model.Sign;

import java.util.ArrayList;
import java.util.List;

public class GameFactory {
    private final PlayerType player1Type;
    private final PlayerType player2Type;

    public GameFactory(final String[] args) {
        CommandLineArgumentParser commandLineArgumentParser = new CommandLineArgumentParser(args);
        CommandLineArgumentParser.PlayerTypes playerTypes = commandLineArgumentParser.parse();
        player1Type = playerTypes.getPlayer1Type();
        player2Type = playerTypes.getPlayer2Type();
    }

    public Game create() {
        final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
        return new Game(
                new DataPrinter(cellNumberConverter),
                new Player(Sign.X, player1Type, cellNumberConverter),
                new Player(Sign.O, player2Type, cellNumberConverter),
                new WinnerVerifier(),
                new CellVerifier(),
                player1Type != player2Type);
    }
}
