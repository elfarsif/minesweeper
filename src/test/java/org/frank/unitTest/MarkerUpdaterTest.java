package org.frank.unitTest;

import org.frank.Game;
import org.frank.markerUpdater.Direction;
import org.frank.models.Coordinate;
import org.frank.models.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MarkerUpdaterTest {
    private Game game;

    @BeforeEach
    void setUpGame() {
        game = new Game();
    }

    @ParameterizedTest
    @MethodSource("generator")
    void checkMarkerExists(Coordinate coordinate) {
        game.placeMine(new Coordinate(1, 1));
        assertThat(game.board.grid[coordinate.row][coordinate.col].state)
                .isEqualTo(State.MARKER);
    }

    private static Stream<Coordinate> generator() {
        Coordinate mine = new Coordinate(1, 1);
        return Stream.of(
                markerLocation(mine, Direction.NORTH),
                markerLocation(mine, Direction.NORTH_EAST),
                markerLocation(mine, Direction.EAST),
                markerLocation(mine, Direction.SOUTH_EAST),
                markerLocation(mine, Direction.SOUTH),
                markerLocation(mine, Direction.SOUTH_WEST),
                markerLocation(mine, Direction.WEST),
                markerLocation(mine, Direction.NORTH_WEST)
        );
    }

    private static Coordinate markerLocation(Coordinate mine, Direction direction) {
        return new Coordinate(mine.row + direction.coordinate.row, mine.col + direction.coordinate.col);
    }
}
