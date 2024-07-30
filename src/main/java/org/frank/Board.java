package org.frank;

public class Board {
    Cell[][] grid2 = new Cell[8][8];

    public Board() {
        initializeEmptyCellsInGrid();
    }

    private void initializeEmptyCellsInGrid() {
        for (Cell[] row : grid2) {
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                row[colIndex] = new Cell();
            }
        }
    }

    public Cell[][] getGrid() {
        return grid2;
    }

    public void updateCell(int row, int col, State state) {
        grid2[row][col].state = state;
    }

    public void setCellVisible(int row, int col) {
        grid2[row][col].isVisible = true;
    }

}
