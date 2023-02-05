package tictactoe;

import tictactoe.model.GameTable;

public interface DataPrinter {

    void printInfoMessage(String message);

    void printErrorMessage(String message);

    void printMappingTable();

    void printGameTable(GameTable gameTable);
}
