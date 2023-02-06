package tictactoe.component;

import tictactoe.model.game.Cell;
import tictactoe.model.game.GameTable;
import tictactoe.model.game.Sign;

import java.util.Random;

public class ComputerMove implements  Move {
    @Override
    public void make(final GameTable gameTable, Sign sign) {
        final Random random = new Random();
        while (true) {
            final int row = random.nextInt(3);
            final int col = random.nextInt(3);
            final Cell randomCell = new Cell(row, col);
            if (gameTable.isEmpty(randomCell)) {
                gameTable.setSign(randomCell, sign);
                return;
            }
        }
    }
}
