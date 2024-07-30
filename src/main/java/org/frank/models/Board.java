package org.frank.models;

public class Board {
    public Cell[][] grid = new Cell[8][8];

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

    public void updateCell(int row, int col) {
        grid[row][col].state = State.MINE;
    }

    public void setCellVisible(int row, int col) {
        grid[row][col].isVisible = true;
    }

    public void updateMarkers(int row, int col) {
        grid[row][col + 1].state = State.MARKER;
        grid[row + 1][col].state = State.MARKER;
    }

    public void updateBoard(int row, int col) {
        updateCell(row, col);
        updateMarkers(row, col);
    }
}
