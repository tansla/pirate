package sevices;

import enums.GameEvent;
import exceptions.OutOfMapException;

public interface EventEmit {

    /**
     * Добавить слушателя для событияю
     * ("подписаться на уведомления")
     * @param evenName имя события
     * @param listener слушатель, которого подписываем (ему будут приходить уведомления)
     */
    void addListener(GameEvent evenName, EventListener listener);
    void removeListener(GameEvent eventName, EventListener listener);

    /**
     * Сообщить всем заинтересованным (подписчикам) о том, что произошло событие
     * @param eventName имя события
     * @param parameter доп.данные о событии
     * @throws OutOfMapException
     */
    void eventEmitting(GameEvent eventName, Object parameter) throws OutOfMapException;

}
