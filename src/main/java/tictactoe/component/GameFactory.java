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
        List<PlayerType> playerTypes = new ArrayList<>();
        for (final String arg : args) {
            String argUpperCase = arg.toUpperCase();
            try {
                PlayerType foundPlayerType = PlayerType.valueOf(argUpperCase);
                playerTypes.add(foundPlayerType);
            } catch (Exception e) {
                System.out.println("Unsupported command line argument: '"+arg+"'");
            }
            if (playerTypes.size() == 2) {
                break;
            }
        }
        if (playerTypes.size() == 0) {
            player1Type = PlayerType.USER;
            player2Type = PlayerType.COMPUTER;
        } else if (playerTypes.size() == 1) {
            player1Type = PlayerType.USER;
            player2Type = playerTypes.get(0);
        } else {
            player1Type = playerTypes.get(0);
            player2Type = playerTypes.get(1);
        }
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
