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

enum Direction {
    NORTH(new Coordinate(-1, 0)),
    EAST(new Coordinate(0, 1)),
    SOUTH(new Coordinate(1, 0)),
    WEST(new Coordinate(0, -1)),
    NORTH_WEST(new Coordinate(-1, -1));

    public final Coordinate coordinate;

    private Direction(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

}
