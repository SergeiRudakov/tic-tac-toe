package tictactoe.component.console;

import tictactoe.DataPrinter;
import tictactoe.component.CellNumberConverter;
import tictactoe.component.UserInputReader;
import tictactoe.model.Cell;

import java.util.Scanner;

public class ConsoleUserInputReader implements UserInputReader {

    private final CellNumberConverter cellNumberConverter;
    private final DataPrinter dataPrinter;

    public ConsoleUserInputReader(final CellNumberConverter cellNumberConverter, final DataPrinter dataPrinter)
    {
        this.cellNumberConverter = cellNumberConverter;
        this.dataPrinter = dataPrinter;
    }

    @Override
    public Cell getUserInput() {
        while (true) {
            dataPrinter.printInfoMessage("Please type number between 1 and 9: ");
            final String userInput = new Scanner(System.in).nextLine();
            if (userInput.length() == 1) {
                final char ch = userInput.charAt(0);
                if (ch >= '1' && ch <= '9') {
                    return cellNumberConverter.toCell(ch);
                }
            }
        }
    }
}
