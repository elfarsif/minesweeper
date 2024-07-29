package org.frank;

public enum State {
    EMPTY(1),
    MINE(2);

    public int value;

    private State(int value) {
        this.value = value;
    }

}
