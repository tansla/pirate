package sevices;

import exceptions.OutOfMapException;

public interface EventEmit {

    /**
     * Добавить слушателя для событияю
     * ("подписаться на уведомления")
     * @param evenName имя события
     * @param listener слушатель, которого подписываем (ему будут приходить уведомления)
     */
    void addListener(String evenName, EventListener listener);
    void removeListener(String eventName, EventListener listener);

    /**
     * Сообщить всем заинтересованным (подписчикам) о том, что произошло событие
     * @param eventName имя события
     * @param parameter доп.данные о событии
     * @throws OutOfMapException
     */
    void eventEmitting(String eventName, Object parameter) throws OutOfMapException;

}
