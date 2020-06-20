package collections;

public class ItemList {

    private Object value;
    private ItemList next;

    public ItemList(Object value) {
        this.value = value;
        this.next = null;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public ItemList getNext() {
        return next;
    }

    public void setNext(ItemList next) {
        this.next = next;
    }
}
