package org.frank.ui;

import org.frank.models.Coordinate;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputParser {

    public static void requestUserClick() {
        Renderer.renderUserPrompt();
    }

    public static Coordinate extractCoordinate(String userInput) {
        Matcher matcher = findMatcherPattern(userInput);
        matcher.find();
        int row = Integer.valueOf(matcher.group(1));
        int col = Integer.valueOf(matcher.group(2));
        return new Coordinate(row, col);
    }

    private static Matcher findMatcherPattern(String userInput) {
        Pattern pattern = Pattern.compile("(\\d+),(\\d+)");
        Matcher matcher = pattern.matcher(userInput);
        return matcher;
    }

    public static Coordinate getUserInput() {
        requestUserClick();
        String userInput = getScannerUserInput();
        return extractCoordinate(userInput);
    }

    private static String getScannerUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        return input;
    }
}
