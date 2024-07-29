package org.frank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;

import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest extends StreamTest {
    private Game game;

    @BeforeEach
    void setUpGame() {
        game = new Game();
    }

    @Test
    void requestUserInput() {
        game.requestUserClick();
        assertThat(outContent.toString())
                .isEqualTo("Enter click in form (row,col)");
    }

    @Test
    void extractCoordinatesFromUserInput() {
        provideInput("(1,2)");
        String input = game.getUserInput();
        Coordinate coordinates = game.extractCoordinate(input);
        assertThat(coordinates)
                .isEqualTo(new Coordinate(1, 2));
    }

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

}