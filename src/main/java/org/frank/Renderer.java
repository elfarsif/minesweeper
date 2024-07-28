package org.frank;

public class Renderer {

    public static void render(int[][] board) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                renderCell(board, row, col);
            }
            renderLastCell(board, row);
        }
    }

    private static void renderCell(int[][] board, int row, int col) {
        if (board[row][col] == State.EMPTY.value) {
            System.out.print("|   ");
        } else {
            System.out.print("|___");
        }
    }

    private static void renderLastCell(int[][] board, int row) {
        if (row == board.length - 1) {
            System.out.print("|");
        } else {
            System.out.print("|\n");
        }
    }

    public static void renderUserPrompt() {
        System.out.print("Enter click in form (row,col)");
    }
}
