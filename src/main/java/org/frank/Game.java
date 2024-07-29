package org.frank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    int[][] board = new int[8][8];

    public void start() {
        Renderer.render(board);
    }

    public void click(int row, int col) {
        board[row][col] = State.EMPTY.value;
        Renderer.render(board);
    }

    public Coordinate getUserInput() {
        return UserInputParser.getUserInput();
    }

}

