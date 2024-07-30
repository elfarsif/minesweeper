package org.frank;

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
        board.updateCell(row, col, State.MINE);
        board.grid2[row][col + 1].state = State.MARKER;
    }

}

