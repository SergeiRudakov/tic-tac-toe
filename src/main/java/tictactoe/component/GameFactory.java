package tictactoe.component;

import tictactoe.DataPrinter;
import tictactoe.component.console.ConsoleDataPrinter;
import tictactoe.component.console.ConsoleUserInputReader;
import tictactoe.keypad.DesktopNumericKeypadCellNumberConverter;
import tictactoe.model.Player;
import tictactoe.model.PlayerType;
import tictactoe.model.Sign;

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
        DataPrinter dataPrinter = new ConsoleDataPrinter(cellNumberConverter);
        UserInputReader userInputReader = new ConsoleUserInputReader(cellNumberConverter, dataPrinter);
        return new Game(
                dataPrinter,
                new Player(Sign.X, player1Type, userInputReader, dataPrinter),
                new Player(Sign.O, player2Type, userInputReader, dataPrinter),
                new WinnerVerifier(),
                new CellVerifier(),
                player1Type != player2Type);
    }
}
