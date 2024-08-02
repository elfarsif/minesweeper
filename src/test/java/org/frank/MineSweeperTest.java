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
                .isEqualTo("Enter click in form (row,col)\n");
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

    @Test
    void placeAMine_thenclickOnEast() {
        game.placeMine(new Coordinate(0, 0));
        game.click(new Coordinate(0, 1));
        assertThat(outContent.toString())
                .isEqualTo("|___| 1 |___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n");
    }

    @Test
    void placingTwoMinesIncreases_TheMarkerValue() {
        game.placeMine(new Coordinate(0, 0));
        game.placeMine(new Coordinate(1, 0));
        game.click(new Coordinate(0, 1));
        assertThat(outContent.toString())
                .isEqualTo("|___| 2 |___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n");
    }

}