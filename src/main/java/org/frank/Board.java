package org.frank;

public class Board {
    int[][] grid = new int[8][8];

    public int[][] getGrid() {
        return grid;
    }

    public void updateCell(int row, int col) {
        grid[row][col] = State.EMPTY.value;
    }
}
