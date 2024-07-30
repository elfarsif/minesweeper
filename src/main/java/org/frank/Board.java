package org.frank;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int[][] grid = new int[8][8];

    public int[][] getGrid() {
        return grid;
    }

    public void updateCell(int row, int col) {
        grid[row][col] = State.EMPTY.value;
    }

    public void updateCell(int row, int col, State state) {
        grid[row][col] = state.value;
    }

}
