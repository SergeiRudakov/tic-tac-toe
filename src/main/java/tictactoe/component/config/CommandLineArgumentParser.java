package tictactoe.component.config;

import tictactoe.model.config.PlayerType;
import tictactoe.model.config.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class CommandLineArgumentParser {

    private final String[] args;

    public CommandLineArgumentParser(final String[] args) {
        this.args = args;
    }

    public GameParameters parse() {
        List<PlayerType> playerTypes = new ArrayList<>();
        UserInterface userInterface = UserInterface.CONSOLE;
        for (final String arg : args) {
            String argUpperCase = arg.toUpperCase();

            if (PlayerType.USER.name().equals(argUpperCase) || PlayerType.COMPUTER.name().equals(argUpperCase)) {
                PlayerType foundPlayerType = PlayerType.valueOf(argUpperCase);
                playerTypes.add(foundPlayerType);
            } else if (UserInterface.GUI.name().equals(argUpperCase) || UserInterface.CONSOLE.name().equals(argUpperCase)) {
                userInterface = UserInterface.valueOf(argUpperCase);
            } else {
                System.err.println("Unsupported command line argument: '" + arg + "'");
            }
        }
        if (playerTypes.size() == 0) {
            return new GameParameters(PlayerType.USER, PlayerType.COMPUTER, userInterface);
        } else if (playerTypes.size() == 1) {
            return new GameParameters(PlayerType.USER, playerTypes.get(0), userInterface);
        } else {
            return new GameParameters(playerTypes.get(0), playerTypes.get(1), userInterface);
        }
    }

    public static class GameParameters {
        private final PlayerType player1Type;
        private final PlayerType player2Type;

        private final UserInterface userInterface;

        private GameParameters(final PlayerType player1Type, final PlayerType player2Type, final UserInterface userInterface) {
            this.player1Type = player1Type;
            this.player2Type = player2Type;
            this.userInterface = userInterface;
        }

        public PlayerType getPlayer1Type() {
            return player1Type;
        }

        public PlayerType getPlayer2Type() {
            return player2Type;
        }

        public UserInterface getUserInterface() {
            return userInterface;
        }
    }
}
