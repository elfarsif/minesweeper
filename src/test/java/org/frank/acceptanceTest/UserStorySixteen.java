package org.frank.acceptanceTest;

import org.frank.Game;
import org.frank.GameContext;
import org.frank.util.StreamTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class UserStorySixteen extends StreamTest {
    private GameContext gameContext;

    @BeforeEach
    public void setUpGame() {
        gameContext = new GameContext();
    }

    @Test
    void whenTheGameLoopStarts_ItShouldAcceptClickInputsContinously() {
        gameContext.start();
        provideInput("(0,0)");
        assertThat(outContent.toString())
                .isEqualTo(
                        startingBoard()
                );
    }

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    String startingBoard() {
        return "|___|___|___|___|___|___|___|___|\n" +
                "|___|___|___|___|___|___|___|___|\n" +
                "|___|___|___|___|___|___|___|___|\n" +
                "|___|___|___|___|___|___|___|___|\n" +
                "|___|___|___|___|___|___|___|___|\n" +
                "|___|___|___|___|___|___|___|___|\n" +
                "|___|___|___|___|___|___|___|___|\n" +
                "|___|___|___|___|___|___|___|___|\n" +
                "Enter click in form (row,col)";
    }

    String boardWithCoordinateRevealed() {
        return "|   |___|___|___|___|___|___|___|\n" +
                "|___|___|___|___|___|___|___|___|\n" +
                "|___|___|___|___|___|___|___|___|\n" +
                "|___|___|___|___|___|___|___|___|\n" +
                "|___|___|___|___|___|___|___|___|\n" +
                "|___|___|___|___|___|___|___|___|\n" +
                "|___|___|___|___|___|___|___|___|\n" +
                "|___|___|___|___|___|___|___|___|\n" +
                "Enter click in form (row,col)";
    }
}