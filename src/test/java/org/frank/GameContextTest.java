package org.frank;

import org.frank.models.Coordinate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameContextTest {
    GameContext gameContext;
    Game gameMock;

    @BeforeEach
    void setup() {
        gameContext = new GameContext();
        gameMock = mock(Game.class);
        gameContext.game = gameMock;
    }

    @Test
    void checkGameIsRunning() {
        when(gameMock.getUserInput())
                .thenReturn(new Coordinate(1, 1));

        gameContext.start();
        assertThat(gameContext.isRunning).isEqualTo(true);
    }

    @Test
    void checkGameIsStopped() {
        gameContext.isRunning = true;
        gameContext.stop();
        assertThat(gameContext.isRunning).isEqualTo(false);
    }

}