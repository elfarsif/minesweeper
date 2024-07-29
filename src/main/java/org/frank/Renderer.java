package org.frank;

public class Renderer {

    public static void render(int[][] board) {
        int rowIndex = 0;
        for (int[] row : board) {
            renderRow(row, rowIndex);
            rowIndex++;
        }
    }

    private static void renderRow(int[] row, int rowIndex) {
        for (int cell : row) {
            renderCell(cell);
        }
        renderLastCellInRow(rowIndex);
    }

    private static void renderCell(int cell) {
        if (cell == State.EMPTY.value) {
            System.out.print("|   ");
        } else {
            System.out.print("|___");
        }
    }

    private static void renderLastCellInRow(int rowIndex) {
        if (rowIndex == 7) {
            System.out.print("|");
        } else {
            System.out.print("|\n");
        }
    }

    public static void renderUserPrompt() {
        System.out.print("Enter click in form (row,col)");
    }
}
