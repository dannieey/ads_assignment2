package models;

public class MyStackLinkedList<T> {
    private MyLinkedList<T> list;

    public MyStackLinkedList() {
        list = new MyLinkedList<>();
    }

    public void push(T element) {
        list.addLast(element);
    }

    public T pop() {
        T top = list.getLast();
        list.removeLast();
        return top;
    }

    public T peek() {
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }
}
