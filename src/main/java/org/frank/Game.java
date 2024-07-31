package org.frank;

import org.frank.models.Board;
import org.frank.models.Coordinate;
import org.frank.ui.Renderer;
import org.frank.ui.UserInputParser;

import java.util.Scanner;

public class Game {
    public Board board = new Board();

    public void start() {
        Renderer.render(board.getGrid());
    }

    public void click(Coordinate coordinate) {
        board.setCellVisible(coordinate);
        Renderer.render(board.getGrid());
    }

    public Coordinate getUserInput() {
        return UserInputParser.getUserInput();
    }

    public void placeMine(Coordinate cordinate) {
        board.addMineToBoard(cordinate);
    }

    public void revealMines() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board.setCellVisible(new Coordinate(i, j));
            }
        }
        Renderer.render(board.getGrid());

    }
}

