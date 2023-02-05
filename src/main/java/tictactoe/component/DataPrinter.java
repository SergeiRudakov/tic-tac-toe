package tictactoe.component;

import tictactoe.model.Cell;
import tictactoe.model.GameTable;

public class DataPrinter {

    private final CellNumberConverter cellNumberConverter;

    public DataPrinter(final CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
    }

    public void printMappingTable() {
        String horizontalSplitter = "-------------";
        for (int i = 0; i < 3; i++) {
            System.out.println(horizontalSplitter);
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + cellNumberConverter.toNumber(new Cell(i,j)) + " ");
            }
            System.out.println("|");
        }
        System.out.println(horizontalSplitter);
    }

    public void printGameTable(final GameTable gameTable) {
        String horizontalSplitter = "-------------";
        for (int i = 0; i < 3; i++) {
            System.out.println(horizontalSplitter);
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + gameTable.getSign(new Cell(i, j)).toString() + " ");
            }
            System.out.println("|");
        }
        System.out.println(horizontalSplitter);
    }
}
