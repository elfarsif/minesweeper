package org.frank.models;

import org.frank.markerUpdater.MarkerUpdater;

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

    public void addMineToBoard(Coordinate coordinate) {
        setCellStateToMine(coordinate);
        updateMarkersSurroundingMine(coordinate);
    }

    public void setCellStateToMine(Coordinate coordinate) {
        grid[coordinate.row][coordinate.col].state = State.MINE;
    }

    public void updateMarkersSurroundingMine(Coordinate mine) {
        MarkerUpdater.updateMarkersSurroundingMine(grid, mine);
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setCellVisible(Coordinate coordinate) {
        grid[coordinate.row][coordinate.col].isVisible = true;
    }
}
