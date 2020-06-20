package sevices;

import exceptions.OutOfMapException;

/** Интерфейс "слушатель событий" */
public interface EventListener {

    /**
     * Получение уведомления о том что произошло событие
     * @param eventName имя события
     * @param parameter доп.данные о мобытии
     * @throws OutOfMapException если что-то случилось с координатами
     */
    void eventHappened(String eventName, Object parameter) throws OutOfMapException;

}
