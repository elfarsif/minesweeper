package org.frank.acceptanceTest;

import org.frank.Game;
import org.frank.util.StreamTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class MarkerTests extends StreamTest {
    private Game game;

    @BeforeEach
    public void setUpGame() {
        game = new Game();
    }

//    @Test
//    void whenISetAMineAtLocation_thenClickMine_itShouldRevealMine() {
//        game.placeMine(0, 0);
//        game.click(0, 1);
//        assertThat(outContent.toString())
//                .isEqualTo("|___| 1 |___|___|___|___|___|___|\n" +
//                        "|___|___|___|___|___|___|___|___|\n" +
//                        "|___|___|___|___|___|___|___|___|\n" +
//                        "|___|___|___|___|___|___|___|___|\n" +
//                        "|___|___|___|___|___|___|___|___|\n" +
//                        "|___|___|___|___|___|___|___|___|\n" +
//                        "|___|___|___|___|___|___|___|___|\n" +
//                        "|___|___|___|___|___|___|___|___|");
//    }

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

}
