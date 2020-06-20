package collections;



public class LinkedList {//список сотрудников

    private ItemList head;//начало списка
    private ItemList tail;//конец списка
    private int length;//Длинаа списка

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public int length(){
        return this.length;
    }

    public Object add(Object value ){//добавение в конец списка
        ItemList newItem = new ItemList(value);
        if (head == null){
            head = newItem;
        }else{
            tail.setNext(newItem);
        }
        tail = newItem;
        this.length++;
        return value;
    }

    public String toString(){//Вывод всего списка
        if (this.head == null) return "Список Пуст";
        ItemList currItem = this.head;
        StringBuilder result = new StringBuilder();
        while(currItem != null ){
            if (result.length() > 0) result.append("\n");
            result.append(currItem.getValue().toString());
            currItem = currItem.getNext();
        }
        return result.toString();
    }

    //Находить значение по Индексу
    public Object get(int index)throws Exception{
        ItemList item = this.head;
        if (index < 0 || index > this.length-1)throw new Exception("Выход за приделы списка!");
        int curIndex = -1;
        while (item != null){
            curIndex++;
            if (curIndex == index) break;
            item = item.getNext();
        }
        return item.getValue();
    }

    //Проверка на присутствие в списке contains
    //добавление в начало списка
    //удаление из списка
}
