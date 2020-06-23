package model;

import exceptions.OutOfMapException;

import java.util.Random;

import static model.Coordinate.maxSize;

public class Treasure implements UsableOnMap {

    private int x;
    private int y;

    public Treasure() {
        this.x = new Random().nextInt(maxSize-1);
        this.y = new Random().nextInt(maxSize-1);

    }

    @Override
    public void doStep() throws OutOfMapException {

    }

    @Override
    public boolean isMovable() {
        return false;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "К";
    }
}
