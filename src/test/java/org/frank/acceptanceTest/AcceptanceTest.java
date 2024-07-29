package org.frank.acceptanceTest;

import org.frank.Coordinate;
import org.frank.Game;
import org.frank.util.StreamTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTest extends StreamTest {
    private Game game;

    @BeforeEach
    public void setUpGame() {
        game = new Game();
    }

    @Test
    void whenTheApplicationStarts_itShouldShowEmptyGameBoard() {
        game.start();
        assertThat(outContent.toString())
                .isEqualTo("|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|");
    }

    @Test
    void whenClickingFirstTile_itShouldRevealEmptyTile() {
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

    @Test
    void userIsAskedForTheirInputs_itShouldRevealTheirClick() {
        provideInput("(0,0)");
        Coordinate coordinate = game.getUserInput();
        game.click(coordinate.row, coordinate.col);
        assertThat(outContent.toString())
                .isEqualTo("Enter click in form (row,col)" +
                        "|   |___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|");
    }

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

}
