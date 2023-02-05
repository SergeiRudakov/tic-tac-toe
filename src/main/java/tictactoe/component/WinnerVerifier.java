package tictactoe.component;

import tictactoe.model.Cell;
import tictactoe.model.GameTable;
import tictactoe.model.Player;
import tictactoe.model.Sign;

public class WinnerVerifier {

    public boolean isWinner(final GameTable gameTable, final Player player) {
        return isWinnerByRows(gameTable, player.getSign())
                || isWinnerByCols(gameTable, player.getSign())
                || isWinnerByMainDiagonal(gameTable, player.getSign())
                || isWinnerBySecondaryDiagonal(gameTable, player.getSign());
    }

    private boolean isWinnerByRows(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(i, 0)) == sign
                    && gameTable.getSign(new Cell(i, 1)) == sign
                    && gameTable.getSign(new Cell(i, 2)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinnerByCols(final GameTable gameTable, final Sign sign) {
        for (int j = 0; j < 3; j++) {
            if (gameTable.getSign(new Cell(0, j)) == sign
                    && gameTable.getSign(new Cell(1, j)) == sign
                    && gameTable.getSign(new Cell(2, j)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinnerByMainDiagonal(final GameTable gameTable, final Sign sign) {
        return gameTable.getSign(new Cell(0, 0)) == sign
                && gameTable.getSign(new Cell(1, 1)) == sign
                && gameTable.getSign(new Cell(2, 2)) == sign;
    }

    private boolean isWinnerBySecondaryDiagonal(final GameTable gameTable, final Sign sign) {
        return gameTable.getSign(new Cell(0, 2)) == sign
                && gameTable.getSign(new Cell(1, 1)) == sign
                && gameTable.getSign(new Cell(2, 0)) == sign;
    }
}
