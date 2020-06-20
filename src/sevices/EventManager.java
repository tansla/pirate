package sevices;

import exceptions.OutOfMapException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager implements EventEmit{

    private Map<String, List<EventListener> > listeners = new HashMap<>();

    public EventManager(String ...eventNames) {
        for (String evenName : eventNames  ) {
            listeners.put(evenName, new ArrayList<>());
        }
    }

    //Добавление нового слушателя
    public void addListener(String evenName, EventListener listener){
        List<EventListener> eventListeners = this.listeners.get(evenName);
        if (eventListeners == null){
            eventListeners = new ArrayList<>();
            listeners.put(evenName, eventListeners);
        }
        eventListeners.add(listener);
    }

    //Удаление
    public void removeListener(String eventName, EventListener listener){
        List<EventListener> eventListeners = listeners.get(eventName);
        if (eventListeners !=null)
            eventListeners.remove(listener);
    }

    //Информатор - издатель
    public void eventEmitting(String eventName, Object parameter) throws OutOfMapException {
        List<EventListener> eventListeners = listeners.get(eventName);
        if (eventListeners !=  null){
            for (EventListener s : eventListeners ) {
                s.eventHappened(eventName, parameter);
            }

        }

    }

}
