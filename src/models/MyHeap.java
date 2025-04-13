package models;

public class MyHeap<T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyHeap() {
        list = new MyArrayList<>();
    }

    public void insert(T element) {
        list.add(element);
        list.sort(); // простая сортировка после вставки
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
