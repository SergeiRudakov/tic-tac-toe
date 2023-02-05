package tictactoe.component;

import tictactoe.model.GameTable;

public interface Move {
    void make(final GameTable gameTable);
}
