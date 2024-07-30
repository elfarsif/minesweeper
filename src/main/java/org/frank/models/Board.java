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

    public void updateCell(Coordinate cordinate) {
        grid[cordinate.row][cordinate.col].state = State.MINE;
    }

    public void setCellVisible(Coordinate coordinate) {
        grid[coordinate.row][coordinate.col].isVisible = true;
    }

    public void updateMarkers(Coordinate coordinate) {
        grid[coordinate.row][coordinate.col + 1].state = State.MARKER;
        grid[coordinate.row + 1][coordinate.col].state = State.MARKER;
        if (coordinate.col != 0) {
            grid[coordinate.row][coordinate.col - 1].state = State.MARKER;
        }
    }

    public void updateBoard(Coordinate coordinate) {
        updateCell(coordinate);
        updateMarkers(coordinate);
    }
}
