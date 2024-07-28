package org.frank;

import org.frank.Renderer;

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

    public void requestUserClick() {
        Renderer.renderUserPrompt();
    }

    public Coordinate extractCoordinate(String userInput) {
        Pattern pattern = Pattern.compile("(\\d+),(\\d+)");
        Matcher matcher = pattern.matcher(userInput);
        matcher.find();
        int row = Integer.valueOf(matcher.group(1));
        int col = Integer.valueOf(matcher.group(2));
        return new Coordinate(row, col);
    }
}

