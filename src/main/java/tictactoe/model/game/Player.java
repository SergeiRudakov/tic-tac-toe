package tictactoe.model.game;

import tictactoe.component.DataPrinter;
import tictactoe.component.Move;
import tictactoe.component.UserInputReader;
import tictactoe.model.config.PlayerType;

public final class Player {
    private final Sign sign;
    private final Move move;

    public Player(final Sign sign, PlayerType playerType, UserInputReader userInputReader, DataPrinter dataPrinter) {
        this.sign = sign;
        this.move = playerType.getMove(userInputReader, dataPrinter);
    }

    public Sign getSign() {
        return sign;
    }

    public void makeMove(final GameTable gameTable) {
        move.make(gameTable, sign);
    }

    @Override
    public String toString() {
        return "'" + sign + "'";
    }
}
