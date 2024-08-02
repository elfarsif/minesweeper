package org.frank;

import org.frank.models.Coordinate;

public class GameContext implements Observer {
    Game game;
    public boolean isRunning;

    public GameContext() {
        game = new Game();
        game.board.registerObserver(this);
    }

    public void start() {
        isRunning = true;
        game.start();
        while (isRunning) {
            Coordinate userInput = game.getUserInput();
            game.click(userInput);
        }
    }

    @Override
    public void update() {
        isRunning = false;
    }
}
