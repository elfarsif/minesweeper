package org.frank.ui;

import org.frank.models.Cell;
import org.frank.models.State;

public class Renderer {

    public static void render(Cell[][] board) {
        int rowIndex = 0;
        for (Cell[] row : board) {
            renderRow(row, rowIndex);
            rowIndex++;
        }
    }

    private static void renderRow(Cell[] row, int rowIndex) {
        for (Cell cell : row) {
            renderCell(cell);
        }
        renderLastCellInRow(rowIndex);
    }

    private static void renderCell(Cell cell) {
        if (cell.isVisible && cell.state == State.MINE) {
            System.out.print("| * ");
        } else if (cell.isVisible && cell.state == State.MARKER) {
            System.out.print("| M ");
        } else if (cell.isVisible) {
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


