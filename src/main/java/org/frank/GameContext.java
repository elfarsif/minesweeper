package org.frank;

import org.frank.models.Coordinate;

public class GameContext {
    Game game;

    public GameContext() {
        game = new Game();
    }

    public boolean isRunning;

    public void start() {
        isRunning = true;

        game.start();
        Coordinate userInput = game.getUserInput();
        game.click(userInput);

    }

    public void stop() {
        isRunning = false;
    }
}
