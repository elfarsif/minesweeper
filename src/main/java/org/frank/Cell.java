package org.frank;

public class Cell {
    State state;
    boolean isVisible;

    public Cell() {
        state = State.EMPTY;
        isVisible = false;
    }
}
