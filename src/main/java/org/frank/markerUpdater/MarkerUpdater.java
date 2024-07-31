package org.frank.markerUpdater;

import org.frank.models.Cell;
import org.frank.models.Coordinate;
import org.frank.models.State;

public class MarkerUpdater {

    public static void updateMarkersSurroundingMine(Cell[][] grid, Coordinate mine) {
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
        if (getCellAdjacentFromMine(grid, mine, direction).markerValue != null) {
            getCellAdjacentFromMine(grid, mine, direction).markerValue += 1;
        } else {
            getCellAdjacentFromMine(grid, mine, direction).markerValue = 1;
        }
    }

    private static Cell getCellAdjacentFromMine(Cell[][] grid, Coordinate mine, Direction direction) {
        return grid[mine.row + direction.coordinate.row][mine.col + direction.coordinate.col];
    }

    private static void updateStateToMarker(Cell[][] grid, Coordinate mine, Direction direction) {
        getCellAdjacentFromMine(grid, mine, direction).state = State.MARKER;
    }

    private static boolean markerLocationIsInsideBoard(Coordinate mine, Direction direction) {
        boolean isValid = true;
        if (mine.row + direction.coordinate.row < 0 || mine.col + direction.coordinate.col < 0) {
            isValid = false;
        }
        return isValid;
    }

}


