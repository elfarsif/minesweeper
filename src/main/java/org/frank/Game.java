package org.frank;

import org.frank.Renderer;

public class Game {
    int[][] board = new int[8][8];

    public void start() {
        Renderer.render(board);
    }

    public void click(int row, int col) {
        board[row][col] = State.EMPTY.value;
        Renderer.render(board);
    }

    public void requestUserClick() {
        Renderer.renderUserPrompt();
    }
}

