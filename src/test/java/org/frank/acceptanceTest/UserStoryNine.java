package org.frank.acceptanceTest;

import org.frank.Game;
import org.frank.models.Coordinate;
import org.frank.util.StreamTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class UserStoryNine extends StreamTest {
    private Game game;

    @BeforeEach
    public void setUpGame() {
        game = new Game();
    }

    @Test
    void whenIStartTheGame_itShouldShowGridAndUserPrompt() {
        game.placeMine(new Coordinate(1, 1));
        game.placeMine(new Coordinate(2, 1));
        game.revealMines();
        assertThat(outContent.toString())
                .isEqualTo("| 1 | 1 | 1 |   |   |   |   |   |\n" +
                        "| 2 | * | 2 |   |   |   |   |   |\n" +
                        "| 2 | * | 2 |   |   |   |   |   |\n" +
                        "| 1 | 1 | 1 |   |   |   |   |   |\n" +
                        "|   |   |   |   |   |   |   |   |\n" +
                        "|   |   |   |   |   |   |   |   |\n" +
                        "|   |   |   |   |   |   |   |   |\n" +
                        "|   |   |   |   |   |   |   |   |\n"
                );
    }

}
