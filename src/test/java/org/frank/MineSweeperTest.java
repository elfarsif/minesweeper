package org.frank;

import org.frank.markerUpdater.Direction;
import org.frank.models.Coordinate;
import org.frank.models.State;
import org.frank.ui.UserInputParser;
import org.frank.util.StreamTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest extends StreamTest {
    private Game game;

    @BeforeEach
    void setUpGame() {
        game = new Game();
    }

    @Test
    void requestUserInput() {
        UserInputParser.requestUserClick();
        assertThat(outContent.toString())
                .isEqualTo("Enter click in form (row,col)");
    }

    @Test
    void extractCoordinatesFromUserInput() {
        provideInput("(1,2)");
        Coordinate coordinates = game.getUserInput();
        assertThat(coordinates)
                .isEqualTo(new Coordinate(1, 2));
    }

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    void placeAMine() {
        game.placeMine(new Coordinate(0, 0));
        assertThat(game.board.grid[0][0].state)
                .isEqualTo(State.MINE);
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
        markerLocation(mine, Direction.EAST);
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