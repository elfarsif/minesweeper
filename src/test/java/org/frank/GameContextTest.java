package org.frank;

import org.frank.models.Board;
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
    Board boardMock;

    @BeforeEach
    void setup() {
        gameContext = new GameContext();
        gameMock = mock(Game.class);
        boardMock = new Board();
        gameMock.board = boardMock;
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
        latch.await(1, TimeUnit.SECONDS);

        assertThat(gameContext.isRunning).isTrue();

    }

    @Test
    void clickingAMineEndsTheGame() {
        GameContext gameContext1 = new GameContext();
        gameContext1.isRunning = true;
        gameContext1.game.placeMine(new Coordinate(0, 0));
        gameContext1.game.click(new Coordinate(0, 0));

        assertThat(gameContext1.isRunning).isFalse();
    }

}