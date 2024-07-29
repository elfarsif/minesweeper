package org.frank;

public class Renderer {

    public static void render(int[][] board) {
        int rowIndex = 0;
        for (int[] row : board) {
            renderRow(row);
            renderLastCell(board, rowIndex);
            rowIndex++;
        }
    }

    private static void renderRow(int[] row) {
        for (int cell : row) {
            renderCell(cell);
        }
    }

    private static void renderCell(int cell) {
        if (cell == State.EMPTY.value) {
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
