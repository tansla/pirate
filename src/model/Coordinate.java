package model;

import exceptions.OutOfMapException;

public class Coordinate {

    public static final int maxSize = 11;

    private int x;
    private int y;

    private void  checkXY(int x, int y) throws OutOfMapException {
        if (x > (maxSize - 1) || x < 0 ||  y > (maxSize - 1) || y < 0)
            throw new OutOfMapException("Неверно указаны координаты");
    }

    public Coordinate(int x, int y) throws OutOfMapException {
        checkXY(x, y);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) throws OutOfMapException {
        checkXY(x, this.y);
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) throws OutOfMapException {
        checkXY(this.x, y);
        this.y = y;
    }
}
