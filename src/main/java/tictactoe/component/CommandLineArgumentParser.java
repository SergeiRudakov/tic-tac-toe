package tictactoe.component;

import tictactoe.model.PlayerType;

import java.util.ArrayList;
import java.util.List;

public class CommandLineArgumentParser {

    private final String[] args;

    public CommandLineArgumentParser(final String[] args) {
        this.args = args;
    }

    public PlayerTypes parse() {
        List<PlayerType> playerTypes = new ArrayList<>();
        for (final String arg : args) {
            String argUpperCase = arg.toUpperCase();
            try {
                PlayerType foundPlayerType = PlayerType.valueOf(argUpperCase);
                playerTypes.add(foundPlayerType);
            } catch (Exception e) {
                System.err.println("Unsupported command line argument: '"+arg+"'");
            }
            if (playerTypes.size() == 2) {
                break;
            }
        }
        if (playerTypes.size() == 0) {
            return new PlayerTypes(PlayerType.USER, PlayerType.COMPUTER);
        } else if (playerTypes.size() == 1) {
            return new PlayerTypes(PlayerType.USER, playerTypes.get(0));
        } else {
            return new PlayerTypes(playerTypes.get(0), playerTypes.get(1));
        }
    }

    public static class PlayerTypes {
        private final PlayerType player1Type;
        private final PlayerType player2Type;

        private PlayerTypes(final PlayerType player1Type, final PlayerType player2Type) {
            this.player1Type = player1Type;
            this.player2Type = player2Type;
        }

        public PlayerType getPlayer1Type() {
            return player1Type;
        }

        public PlayerType getPlayer2Type() {
            return player2Type;
        }
    }
}
