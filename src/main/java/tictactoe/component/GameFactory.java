package tictactoe.component;

import tictactoe.component.console.ConsoleDataPrinter;
import tictactoe.component.console.ConsoleGameOverHandler;
import tictactoe.component.console.ConsoleUserInputReader;
import tictactoe.component.swing.GameWindow;
import tictactoe.keypad.DesktopNumericKeypadCellNumberConverter;
import tictactoe.model.Player;
import tictactoe.model.PlayerType;
import tictactoe.model.Sign;
import tictactoe.model.UserInterface;

public class GameFactory {
    private final PlayerType player1Type;
    private final PlayerType player2Type;
    private final UserInterface userInterface;

    public GameFactory(final String[] args) {
        CommandLineArgumentParser commandLineArgumentParser = new CommandLineArgumentParser(args);
        CommandLineArgumentParser.GameParameters gameParameters = commandLineArgumentParser.parse();
        player1Type = gameParameters.getPlayer1Type();
        player2Type = gameParameters.getPlayer2Type();
        userInterface = gameParameters.getUserInterface();
    }

    public Game create() {
        final DataPrinter dataPrinter;
        final UserInputReader userInputReader;
        final GameOverHandler gameOverHandler;

        if (userInterface == UserInterface.GUI) {
            final GameWindow gameWindow = new GameWindow();
            dataPrinter = gameWindow;
            userInputReader = gameWindow;
            gameOverHandler = gameWindow;
        } else {
            final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
            dataPrinter = new ConsoleDataPrinter(cellNumberConverter);
            userInputReader = new ConsoleUserInputReader(cellNumberConverter, dataPrinter);
            gameOverHandler = new ConsoleGameOverHandler(dataPrinter);
        }

        return new Game(
                dataPrinter,
                new Player(Sign.X, player1Type, userInputReader, dataPrinter),
                new Player(Sign.O, player2Type, userInputReader, dataPrinter),
                new WinnerVerifier(),
                new CellVerifier(),
                gameOverHandler,
                player1Type != player2Type);
    }
}
