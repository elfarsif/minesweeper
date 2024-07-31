package org.frank.markerUpdater;

import org.frank.models.Coordinate;

public enum Direction {
    NORTH(new Coordinate(-1, 0)),
    NORTH_EAST(new Coordinate(-1, 1)),
    EAST(new Coordinate(0, 1)),
    SOUTH_EAST(new Coordinate(1, 1)),
    SOUTH(new Coordinate(1, 0)),
    SOUTH_WEST(new Coordinate(1, -1)),
    WEST(new Coordinate(0, -1)),
    NORTH_WEST(new Coordinate(-1, -1));

    public final Coordinate coordinate;

    private Direction(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

}
