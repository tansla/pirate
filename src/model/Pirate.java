package model;

import dto.ChangeCoordinates;
import exceptions.OutOfMapException;
import sevices.EventEmit;
import sevices.EventListener;

public class Pirate extends Creature implements UsableOnMap, EventListener {

    private String name;
    //Пункт назначения
    private Coordinate destination = null;

    private EventEmit eventEmit;

    public Pirate(Coordinate coordinate,
                  int stamina,
                  String name,
                  EventEmit eventEmit) {

        super(coordinate, stamina);

        this.name = name;

        this.eventEmit = eventEmit;
        this.eventEmit.addListener("ADD_NEW_OBJECT", this);
    }

    public String toString(){
        return "П";
    }

    @Override
    public void eventHappened(String eventName, Object parameter) throws OutOfMapException {
        System.out.println("Пират ["+eventName+"]");
        switch (eventName) {
            case "ADD_NEW_OBJECT":
                System.out.println(name +": \" Я что-то заметил !!! \"");
                if (this == parameter) {
                    System.out.println(name+": \"Ой... так этож я\"");
                } else if (parameter instanceof UsableOnMap) {
                    UsableOnMap param = (UsableOnMap)parameter;
                    destination = new Coordinate(param.getX(), param.getY());
                } else {
                    System.out.println("Параметр неизвестного типа "+parameter.getClass());
                }
                break;
            default:
                System.out.println("Событие не обрабатывается - "+eventName);
        }
    }

    @Override
    public void doStep() throws OutOfMapException {
        Coordinate self = this.getCoordinate();

        if (this.destination != null){
            ChangeCoordinates change = new ChangeCoordinates();
            change.setWere(new Coordinate(self.getX(), self.getY()));
            change.setObj(this);
            int step;
            if (self.getX() != this.destination.getX()){
                step = (self.getX() > this.destination.getX())? -1 : 1;
                self.setX(self.getX() + step);
            }else if (self.getY() != this.destination.getY()){
                step = (self.getY() > this.destination.getY())? -1 : 1;
                self.setY(self.getY() + step);
            }else{
                System.out.println( "Я на месте");
                this.destination = null;
            }
            change.setBecame(new Coordinate(self.getX(), self.getY()));
            eventEmit.eventEmitting("CHANGE_COORDINATE", change);
        }

    }

    @Override
    public boolean isMovable() {
        return true;
    }

    @Override
    public int getX() {
        return this.getCoordinate().getX();
    }

    @Override
    public int getY() {
        return this.getCoordinate().getY();
    }
}
