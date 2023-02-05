package tictactoe.component;

import tictactoe.model.GameTable;
import tictactoe.model.Player;

import java.util.Random;

public class Game {
    private final DataPrinter dataPrinter;
    private final Player player1;
    private final Player player2;
    private final WinnerVerifier winnerVerifier;
    private final CellVerifier cellVerifier;
    private final boolean canSecondPlayerMakeFirstMove;

    public Game(final DataPrinter dataPrinter, final Player player1, final Player player2, final WinnerVerifier winnerVerifier, final CellVerifier cellVerifier, final boolean canSecondPlayerMakeFirstMove) {
        this.dataPrinter = dataPrinter;
        this.player1 = player1;
        this.player2 = player2;
        this.winnerVerifier = winnerVerifier;
        this.cellVerifier = cellVerifier;
        this.canSecondPlayerMakeFirstMove = canSecondPlayerMakeFirstMove;
    }

    public void play() {
        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        dataPrinter.printMappingTable();

        final Player[] players = {player1, player2};

        final GameTable gameTable = new GameTable();
        if (canSecondPlayerMakeFirstMove && new Random().nextBoolean()) {
            player2.makeMove(gameTable);
            dataPrinter.printGameTable(gameTable);
        }

        while (true) {
            for (final Player player : players) {
                player.makeMove(gameTable);
                dataPrinter.printGameTable(gameTable);
                if (winnerVerifier.isWinner(gameTable, player)) {
                    System.out.println(player +" WIN");
                    printGameOver();
                    return;
                }
                if (cellVerifier.allCellsFilled(gameTable)) {
                    System.out.println("Sorry, DRAW!");
                    printGameOver();
                    return;
                }
            }
        }
    }

    private static void printGameOver() {
        System.out.println("GAME OVER");
    }
}
