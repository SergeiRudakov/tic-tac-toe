package tictactoe.component;

import tictactoe.model.Cell;
import tictactoe.model.GameTable;

public class WinnerVerifier {

    public boolean isUserWin(final GameTable gameTable) {
        return isWinner(gameTable, 'X');
    }

    public boolean isComputerWin(final GameTable gameTable) {
        return isWinner(gameTable, 'O');
    }

    private boolean isWinner(final GameTable gameTable, final char sign) {
        return isWinnerByRows(gameTable, sign)
                || isWinnerByCols(gameTable, sign)
                || isWinnerByMainDiagonal(gameTable, sign)
                || isWinnerBySecondaryDiagonal(gameTable, sign);
    }

    private boolean isWinnerByRows(final GameTable gameTable, final char sign) {
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(i, 0)) == sign
                    && gameTable.getSign(new Cell(i, 1)) == sign
                    && gameTable.getSign(new Cell(i, 2)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinnerByCols(final GameTable gameTable, final char sign) {
        for (int j = 0; j < 3; j++) {
            if (gameTable.getSign(new Cell(0, j)) == sign
                    && gameTable.getSign(new Cell(1, j)) == sign
                    && gameTable.getSign(new Cell(2, j)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinnerByMainDiagonal(final GameTable gameTable, final char sign) {
        return gameTable.getSign(new Cell(0, 0)) == sign
                && gameTable.getSign(new Cell(1, 1)) == sign
                && gameTable.getSign(new Cell(2, 2)) == sign;
    }

    private boolean isWinnerBySecondaryDiagonal(final GameTable gameTable, final char sign) {
        return gameTable.getSign(new Cell(0, 2)) == sign
                && gameTable.getSign(new Cell(1, 1)) == sign
                && gameTable.getSign(new Cell(2, 0)) == sign;
    }
}
