package org.frank;

import org.frank.models.Coordinate;

public class GameContext {
    Game game;

    public GameContext() {
        game = new Game();
    }

    public void start() {
        game.start();
        Coordinate userInput = game.getUserInput();
        game.click(userInput);
    }
}
