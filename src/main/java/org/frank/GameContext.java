package org.frank;

public class GameContext {
    Game game;

    public GameContext() {
        game = new Game();
    }

    public void start() {
        game.start();
        game.getUserInput();
    }
}
