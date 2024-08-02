package org.frank;

import org.frank.models.Coordinate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

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
    void checkGameHasStarted() throws InterruptedException {
        Coordinate mockCoordinate = mock(Coordinate.class);
        when(gameMock.getUserInput()).thenReturn(mockCoordinate);
        doNothing().when(gameMock).start();

        CountDownLatch latch = new CountDownLatch(1);
        Thread startThread = new Thread(() -> {
            gameContext.start();
            latch.countDown();
        });

        startThread.start();
        latch.await(2, TimeUnit.SECONDS);

        assertThat(gameContext.isRunning).isTrue();

    }

}