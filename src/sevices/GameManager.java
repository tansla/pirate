package sevices;


import exceptions.OutOfMapException;
import model.*;

import java.util.LinkedList;
import java.util.List;

public class GameManager implements EventListener {

    //Массив сумеющих двигаться объектов;
    private List<UsableOnMap> movableObjectList = new LinkedList<>();

    //Наша карта
    private LocalMap localMap;
    private boolean isGameOver = false;

    private EventEmit event;



    public GameManager(LocalMap localMap) {
        this.localMap = localMap;
    }

    public GameManager() {
      this(new EventManager());
    }

    public GameManager(EventEmit event) {
        this.event = event;
        this.event.addListener("GAME_OVER", this);
        this.localMap = new LocalMap(event);
    }

    @Override
    public void eventHappened(String eventName, Object parameter) {
        System.out.println("GameMaster");
        switch (eventName){
            case "GAME_OVER":
               this.isGameOver = true;
                System.out.println("Игра окончена");
                break;
            default:
                System.out.println("Событие не обрабатывается - "+eventName);
        }
    }

    private void init() throws OutOfMapException {
             Pirate pirate = new Pirate(new Coordinate(5, 5), 25, "Сильвер", event);
             movableObjectList.add(pirate);
             localMap.addNewObject(pirate);
    }

    public void run(){
        try{
            init();
            int iterator = 20;
            while (!this.isGameOver && iterator > 0){
                System.out.println(localMap.toString());
                for (UsableOnMap  objToMove : movableObjectList) {
                    objToMove.doStep();
                }

                iterator--;
                if (iterator == 18)localMap.addNewObject(new Treasure());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
