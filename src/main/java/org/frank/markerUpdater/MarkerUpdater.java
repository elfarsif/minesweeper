package org.frank.markerUpdater;

import org.frank.models.Cell;
import org.frank.models.Coordinate;
import org.frank.models.State;

public class MarkerUpdater {

    public static void update(Cell[][] grid, Coordinate mine) {
        for (Direction direction : Direction.values()) {
            updateMarker(grid, mine, direction);
        }
    }

    private static void updateMarker(Cell[][] grid, Coordinate mine, Direction direction) {
        if (markerLocationIsInsideBoard(mine, direction)) {
            updateStateToMarker(grid, mine, direction);
            updateMarkerValue(grid, mine, direction);
        }
    }

    private static void updateMarkerValue(Cell[][] grid, Coordinate mine, Direction direction) {
        if (grid[mine.row + direction.coordinate.row][mine.col + direction.coordinate.col].markerValue != null) {
            grid[mine.row + direction.coordinate.row][mine.col + direction.coordinate.col].markerValue += 1;
        } else {
            grid[mine.row + direction.coordinate.row][mine.col + direction.coordinate.col].markerValue = 1;
        }
    }

    private static void updateStateToMarker(Cell[][] grid, Coordinate mine, Direction direction) {
        grid[mine.row + direction.coordinate.row][mine.col + direction.coordinate.col].state = State.MARKER;
    }

    private static boolean markerLocationIsInsideBoard(Coordinate mine, Direction direction) {
        boolean isValid = true;
        if (mine.row + direction.coordinate.row < 0 || mine.col + direction.coordinate.col < 0) {
            isValid = false;
        }
        return isValid;
    }

}


