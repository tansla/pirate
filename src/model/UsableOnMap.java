package model;

import exceptions.OutOfMapException;

public interface UsableOnMap {

    void doStep() throws OutOfMapException;// Объект делает шаг
    boolean isMovable();//true - если объект может перемещаться сам
    int getX();
    int getY();

}
