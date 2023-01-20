package tictactoe;

public class Launcher {
    public static void main(final String[] args) {
        final Game game = new Game(new DataPrinter(), new ComputerMove(), new UserMove(), new WinnerVerifier(), new DrawVerifier());
        game.play();
    }
}
