package org.frank;

import org.frank.models.Board;
import org.frank.models.Coordinate;
import org.frank.ui.Renderer;
import org.frank.ui.UserInputParser;

public class Game {
    Board board = new Board();

    public void start() {
        Renderer.render(board.getGrid());
    }

    public void click(int row, int col) {
        board.setCellVisible(row, col);
        Renderer.render(board.getGrid());
    }

    public Coordinate getUserInput() {
        return UserInputParser.getUserInput();
    }

    public void placeMine(int row, int col) {
        board.updateBoard(row, col);
    }

}

