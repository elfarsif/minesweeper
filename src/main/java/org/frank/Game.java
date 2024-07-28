package org.frank;

public class Game {
    int[][] board = new int[8][8];

    public void start() {
        renderBoard();
    }

    public void click(int row, int col) {
        board[row][col] = State.EMPTY.value;
        renderBoard();
    }

    private void renderBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                renderCell(row, col);
            }
            renderLastCell(row);
        }
    }

    private void renderCell(int row, int col) {
        if (board[row][col] == State.EMPTY.value) {
            System.out.print("|   ");
        } else {
            System.out.print("|___");
        }
    }

    private void renderLastCell(int row) {
        if (row == board.length - 1) {
            System.out.print("|");
        } else {
            System.out.print("|\n");
        }
    }
}

