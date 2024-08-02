package org.frank.models;

import org.frank.Observer;
import org.frank.markerUpdater.MarkerUpdater;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public Cell[][] grid = new Cell[8][8];
    List<Observer> observers = new ArrayList<>();

    public Board() {
        initializeEmptyCellsInGrid();
    }

    private void initializeEmptyCellsInGrid() {
        for (Cell[] row : grid) {
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                row[colIndex] = new Cell();
            }
        }
    }

    public void addMineToBoard(Coordinate coordinate) {
        setCellStateToMine(coordinate);
        updateMarkersSurroundingMine(coordinate);
    }

    public void setCellStateToMine(Coordinate coordinate) {
        grid[coordinate.row][coordinate.col].state = State.MINE;
    }

    public void updateMarkersSurroundingMine(Coordinate mine) {
        MarkerUpdater.updateMarkersSurroundingMine(grid, mine);
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setCellVisible(Coordinate coordinate) {
        if (grid[coordinate.row][coordinate.col].state == State.MINE) {
            notifyObservers();
        }
        grid[coordinate.row][coordinate.col].isVisible = true;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void setAllCellsToVisible() {
        for (int rowIndex = 0; rowIndex < 8; rowIndex++) {
            for (int colIndex = 0; colIndex < 8; colIndex++) {
                setCellVisible(new Coordinate(rowIndex, colIndex));
            }
        }
    }
}
