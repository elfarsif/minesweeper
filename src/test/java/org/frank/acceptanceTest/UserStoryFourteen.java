package org.frank.acceptanceTest;

import org.frank.Game;
import org.frank.util.StreamTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserStoryFourteen extends StreamTest {
    private Game game;

    @BeforeEach
    public void setUpGame() {
        game = new Game();
    }

    @Test
    void testingd() {
        assertThat(1).isEqualTo(1);
    }

    @Test
    void whenIStartTheGame_itShouldShowGridAndUserPrompt() {
        game.start();
        assertThat(outContent.toString())
                .isEqualTo("|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "|___|___|___|___|___|___|___|___|\n" +
                        "Enter click in form (row,col)");
    }

}
