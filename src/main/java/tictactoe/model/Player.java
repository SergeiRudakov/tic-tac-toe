package tictactoe.model;

import tictactoe.component.CellNumberConverter;
import tictactoe.component.Move;

public final class Player {
    private final Sign sign;
    private final Move move;

    public Player(final Sign sign, PlayerType playerType, CellNumberConverter cellNumberConverter) {
        this.sign = sign;
        this.move = playerType.getMove(cellNumberConverter);
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
