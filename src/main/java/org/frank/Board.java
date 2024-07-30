package org.frank;

public class Board {
    Cell[][] grid = new Cell[8][8];

    public Board() {
        initializeEmptyCellsInGrid();
    }

    private void initializeEmptyCellsInGrid() {
        for (Cell[] row : grid) {
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                row[colIndex] = new Cell();
            }
        }
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void updateCell(int row, int col, State state) {
        grid[row][col].state = state;
    }

    public void setCellVisible(int row, int col) {
        grid[row][col].isVisible = true;
    }

}
