package org.frank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;

import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Game game;

    @BeforeEach
    public void setUpStreams() {
        game = new Game();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void acceptanceTest_whenStartsTheApplication_itShouldShowGameBoard() {
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
    void acceptanceTest_whenClickingEmptyTile() {
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
    void requestUserInput() {
        game.requestUserClick();
        assertThat(outContent.toString())
                .isEqualTo("Enter click in form (row,col)");
    }

    @Test
    void extractRowFromInput() {
        game.requestUserClick();
        Coordinate coordinates = game.extractCoordinate("(1,2)");
        assertThat(coordinates)
                .isEqualTo(new Coordinate(1, 2));
    }

    @Test
    void spike_retrieveAndTestUserInput() {
        provideInput("hello");
        String input = game.readName();
        assertThat(input)
                .isEqualTo("hello");
    }

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
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