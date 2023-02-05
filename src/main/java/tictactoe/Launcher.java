package tictactoe;

import tictactoe.component.*;

public class Launcher {
    public static void main(final String[] args) {
        GameFactory gameFactory = new GameFactory(args);
        Game game = gameFactory.create();
        game.play();
    }
}
