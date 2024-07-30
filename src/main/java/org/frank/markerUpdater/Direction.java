package org.frank.markerUpdater;

import org.frank.models.Coordinate;

public enum Direction {
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
