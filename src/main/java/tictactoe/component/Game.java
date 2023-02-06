package tictactoe.component;

import tictactoe.model.game.GameTable;
import tictactoe.model.game.Player;

import java.util.Random;

public class Game {
    private final DataPrinter dataPrinter;
    private final Player player1;
    private final Player player2;
    private final WinnerVerifier winnerVerifier;
    private final CellVerifier cellVerifier;
    private final GameOverHandler gameOverHandler;
    private final boolean canSecondPlayerMakeFirstMove;

    public Game(final DataPrinter dataPrinter, final Player player1, final Player player2, final WinnerVerifier winnerVerifier, final CellVerifier cellVerifier, final GameOverHandler gameOverHandler, final boolean canSecondPlayerMakeFirstMove) {
        this.dataPrinter = dataPrinter;
        this.player1 = player1;
        this.player2 = player2;
        this.winnerVerifier = winnerVerifier;
        this.cellVerifier = cellVerifier;
        this.gameOverHandler = gameOverHandler;
        this.canSecondPlayerMakeFirstMove = canSecondPlayerMakeFirstMove;
    }

    public void play() {
        dataPrinter.printInstructions();

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
                    dataPrinter.printInfoMessage(player +" WIN");
                    gameOverHandler.gameOver();
                    return;
                }
                if (cellVerifier.allCellsFilled(gameTable)) {
                    dataPrinter.printInfoMessage("Sorry, DRAW!");
                    gameOverHandler.gameOver();
                    return;
                }
            }
        }
    }
}
