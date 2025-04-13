package models;

public class MyQueueLinkedList<T> {
    private MyLinkedList<T> list;

    public MyQueueLinkedList() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T element) {
        list.addLast(element);
    }

    public T dequeue() {
        T front = list.getFirst();
        list.removeFirst();
        return front;
    }

    public T peek() {
        return list.getFirst();
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
