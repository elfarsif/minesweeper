package org.frank;

import org.frank.util.StreamTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

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

    private void renderInitialBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                System.out.print("|___");
            }
            if (row == 8 - 1) {
                System.out.print("|");
                continue;
            }
            System.out.print("|\n");
        }
    }

    @Test
    void acceptanceTest_whenClickingEmptyTile() {
        Game game = new Game();
        game.click(0, 0);
        assertThat(outContent.toString())
                .isEqualTo("|   |___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|");
    }

}