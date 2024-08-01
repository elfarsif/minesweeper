package org.frank;

import org.frank.models.Coordinate;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        game.placeMine(new Coordinate(0, 0));
        game.placeMine(new Coordinate(0, 1));
        game.placeMine(new Coordinate(0, 2));
        Coordinate userClick = game.getUserInput();
        game.click(userClick);
    }
}