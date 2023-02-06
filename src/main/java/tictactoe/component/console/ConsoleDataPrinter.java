package tictactoe.component.console;

import tictactoe.component.DataPrinter;
import tictactoe.component.CellNumberConverter;
import tictactoe.model.Cell;
import tictactoe.model.GameTable;

public class ConsoleDataPrinter implements DataPrinter {
    private final CellNumberConverter cellNumberConverter;

    public ConsoleDataPrinter(final CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
    }

    @Override
    public void printInstructions() {
        printInfoMessage("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        print((i,j) -> String.valueOf(cellNumberConverter.toNumber(new Cell(i,j))));
    }

    @Override
    public void printInfoMessage(final String message) {
        System.out.println(message);
    }

    @Override
    public void printErrorMessage(final String message) {
        System.err.println(message);
    }

    @Override
    public void printGameTable(final GameTable gameTable) {
        print((i,j) -> gameTable.getSign(new Cell(i, j)).toString());
    }

    private void print(final ConsoleDataPrinter.Lambda lambda) {
        String horizontalSplitter = "-------------";
        for (int i = 0; i < 3; i++) {
            System.out.println(horizontalSplitter);
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + lambda.getValue(i, j) + " ");
            }
            System.out.println("|");
        }
        System.out.println(horizontalSplitter);
    }

    @FunctionalInterface
    private interface Lambda {
        String getValue(int i, int j);
    }
}
