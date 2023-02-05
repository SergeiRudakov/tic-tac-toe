package tictactoe.component;

import tictactoe.model.GameTable;
import tictactoe.model.Sign;

public interface Move {
    void make(final GameTable gameTable, Sign sign);
}
