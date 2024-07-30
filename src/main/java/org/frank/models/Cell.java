package org.frank.models;

public class Cell {
    public State state;
    public boolean isVisible;

    public Cell() {
        state = State.EMPTY;
        isVisible = false;
    }

}
