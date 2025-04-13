package models;

public class MyMinHeapLinkedList<T extends Comparable<T>> {
    private MyLinkedList<T> list;

    public MyMinHeapLinkedList() {
        list = new MyLinkedList<>();
    }

    public void insert(T element) {
        list.add(element);
        list.sort(); // простая сортировка после добавления
    }

    public T peekMin() {
        return list.getFirst();
    }

    public T removeMin() {
        T min = list.getFirst();
        list.removeFirst();
        return min;
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
