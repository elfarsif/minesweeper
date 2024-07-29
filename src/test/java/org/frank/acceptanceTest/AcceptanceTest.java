package org.frank.acceptanceTest;

import org.frank.Game;
import org.frank.StreamTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

//    @Test
//    void acceptanceTest_whenUserEntersTwoZerosUserClick() {
//        game.requestUserClick();
//        game.executeUserClick();
//        assertThat(outContent.toString())
//                .isEqualTo("|   |___|___|___|___|___|___|___|\n" +
//                        "|___|___|___|___|___|___|___|___|\n" +
//                        "|___|___|___|___|___|___|___|___|\n" +
//                        "|___|___|___|___|___|___|___|___|\n" +
//                        "|___|___|___|___|___|___|___|___|\n" +
//                        "|___|___|___|___|___|___|___|___|\n" +
//                        "|___|___|___|___|___|___|___|___|\n" +
//                        "|___|___|___|___|___|___|___|___|");
//    }

}
