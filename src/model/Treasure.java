package model;

import exceptions.OutOfMapException;

public class Treasure implements UsableOnMap {

    @Override
    public void doStep() throws OutOfMapException {

    }

    @Override
    public boolean isMovable() {
        return false;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public String toString() {
        return "К";
    }
}
