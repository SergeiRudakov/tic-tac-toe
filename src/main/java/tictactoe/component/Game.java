package tictactoe.component;

import tictactoe.model.GameTable;
import tictactoe.model.Player;
import tictactoe.model.Sign;

import java.util.Random;

public class Game {
    private final DataPrinter dataPrinter;
    private final ComputerMove computerMove;
    private final UserMove userMove;
    private final WinnerVerifier winnerVerifier;
    private final CellVerifier cellVerifier;

    public Game(final DataPrinter dataPrinter, final ComputerMove computerMove, final UserMove userMove, final WinnerVerifier winnerVerifier, final CellVerifier cellVerifier) {
        this.dataPrinter = dataPrinter;
        this.computerMove = computerMove;
        this.userMove = userMove;
        this.winnerVerifier = winnerVerifier;
        this.cellVerifier = cellVerifier;
    }

    public void play() {
        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        dataPrinter.printMappingTable();

        final Player user = new Player(Sign.X, userMove);
        final Player computer = new Player(Sign.O, computerMove);
        final Player[] players = {user, computer};

        final GameTable gameTable = new GameTable();
        if (new Random().nextBoolean()) {
            computer.makeMove(gameTable);
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
