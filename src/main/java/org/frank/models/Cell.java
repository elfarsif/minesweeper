package org.frank.models;

public class Cell {
    public State state;
    public boolean isVisible;
    public Integer markerValue;

    public Cell() {
        state = State.EMPTY;
        isVisible = false;
    }

}
