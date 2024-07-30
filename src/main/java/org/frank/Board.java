package org.frank;

import java.util.ArrayList;
import java.util.List;

public class Board {
    Cell[][] grid2 = new Cell[8][8];

    public Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid2[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getGrid() {
        return grid2;
    }

    public void updateCell(int row, int col) {
        grid2[row][col].state = State.EMPTY;
    }

    public void updateCell(int row, int col, State state) {
        grid2[row][col].state = state;
    }

    public void setCellVisible(int row, int col) {
        grid2[row][col].isVisible = true;
    }
}
