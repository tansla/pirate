package model;

import dto.ChangeCoordinates;
import exceptions.OutOfMapException;
import sevices.EventEmit;
import sevices.EventListener;

public class LocalMap implements EventListener {

    //Располоожение элементов на карте
    private UsableOnMap[][] map = new UsableOnMap[Coordinate.maxSize][Coordinate.maxSize];
    private EventEmit eventEmit;


    public LocalMap() {
        for (int i = 0; i < Coordinate.maxSize; i++) {
            for (int j = 0; j < Coordinate.maxSize; j++) {
                map[i][j] = null;
            }
        }
    }

    public LocalMap(EventEmit eventEmit) {
        this();
        this.eventEmit = eventEmit;
        this.eventEmit.addListener("CHANGE_COORDINATE", this);

    }

    public String toString(){
        StringBuilder resStr = new StringBuilder();
        for (int i = 0; i < Coordinate.maxSize; i++) {
            for (int j = 0; j < Coordinate.maxSize; j++) {
                resStr.append( (map[i][j] != null)? map[i][j].toString() : "-"  );
            }
            resStr.append("\n");
        }
        return resStr.toString();
    }

    @Override
    public void eventHappened(String eventName, Object parameter) {
        System.out.println("LocalMap");
        switch (eventName){
            case "CHANGE_COORDINATE" :
                if (parameter instanceof ChangeCoordinates) {
                    Coordinate were = ((ChangeCoordinates) parameter).getWere();
                    Coordinate became = ((ChangeCoordinates) parameter).getBecame();
                    map[were.getX()][were.getY()] = null;
                    map[became.getX()][became.getY()] = (UsableOnMap) ((ChangeCoordinates) parameter).getObj();
                }
                break;
            default:
                System.out.println("Событие не обрабатывается - "+eventName);

        }
    }

    public void addNewObject(UsableOnMap obj) throws OutOfMapException {
        map[obj.getX()][obj.getY()] = obj;
        eventEmit.eventEmitting("ADD_NEW_OBJECT", obj);
    }

}
