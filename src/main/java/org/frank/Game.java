package org.frank;

public class Game {
    Board board = new Board();

    public void start() {
        Renderer.render(board.getGrid());
    }

    public void click(int row, int col) {
        board.updateCell(row, col);
        Renderer.render(board.getGrid());
    }

    public Coordinate getUserInput() {
        return UserInputParser.getUserInput();
    }

    public void placeMine(int row, int col) {

    }
}

