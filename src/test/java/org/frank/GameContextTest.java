package org.frank;

import org.frank.util.StreamTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameContextTest extends StreamTest {
    private GameContext gameContext;

    @BeforeEach
    public void setUpGame() {
        gameContext = new GameContext();
    }

    @Test
    void whenTheGameLoopStarts_ItShouldStartTheBoard() {
        gameContext.start();
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
                "Enter click in form (row,col)\n";
    }

}