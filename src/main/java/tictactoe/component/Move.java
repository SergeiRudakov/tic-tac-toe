package tictactoe.component;

import tictactoe.model.game.GameTable;
import tictactoe.model.game.Sign;

public interface Move {
    void make(final GameTable gameTable, Sign sign);
}
