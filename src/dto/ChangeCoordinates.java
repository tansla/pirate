package dto;

import model.Coordinate;
import model.UsableOnMap;

public class ChangeCoordinates {

    private Coordinate were;
    private Coordinate became;
    private UsableOnMap obj;

    public Coordinate getWere() {
        return were;
    }

    public void setWere(Coordinate were) {
        this.were = were;
    }

    public Coordinate getBecame() {
        return became;
    }

    public void setBecame(Coordinate became) {
        this.became = became;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(UsableOnMap obj) {
        this.obj = obj;
    }
}
