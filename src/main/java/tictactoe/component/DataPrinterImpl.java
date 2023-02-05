package tictactoe.component;

import tictactoe.model.Cell;
import tictactoe.model.GameTable;

public class DataPrinterImpl {

    private final CellNumberConverter cellNumberConverter;

    public DataPrinterImpl(final CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
    }

    public void printMappingTable() {
        print((i,j) -> String.valueOf(cellNumberConverter.toNumber(new Cell(i,j))));
    }

    public void printGameTable(final GameTable gameTable) {
        print((i,j) -> gameTable.getSign(new Cell(i, j)).toString());
    }

    private void print(final Lambda lambda) {
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
