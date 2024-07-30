package org.frank;

import org.frank.models.Cell;
import org.frank.models.Coordinate;
import org.frank.models.State;

public class MarkerUpdater {

    public static void update(Cell[][] grid, Coordinate coordinate) {
        updateRightMarker(grid, coordinate);
        updateSouthMarker(grid, coordinate);
        updateWestMarker(grid, coordinate);
        updateNorthMarker(grid, coordinate);
        updateNorthWestMarker(grid, coordinate);
    }

    private static void updateNorthWestMarker(Cell[][] grid, Coordinate coordinate) {
        if (coordinate.row != 0 && coordinate.col != 0) {
            grid[coordinate.row - 1][coordinate.col - 1].state = State.MARKER;
        }
    }

    private static void updateNorthMarker(Cell[][] grid, Coordinate coordinate) {
        if (coordinate.row != 0) {
            grid[coordinate.row - 1][coordinate.col].state = State.MARKER;
        }
    }

    private static void updateWestMarker(Cell[][] grid, Coordinate coordinate) {
        if (coordinate.col != 0) {
            grid[coordinate.row][coordinate.col - 1].state = State.MARKER;
        }
    }

    private static void updateSouthMarker(Cell[][] grid, Coordinate coordinate) {
        grid[coordinate.row + 1][coordinate.col].state = State.MARKER;
    }

    private static void updateRightMarker(Cell[][] grid, Coordinate coordinate) {
        grid[coordinate.row][coordinate.col + 1].state = State.MARKER;
    }

}
