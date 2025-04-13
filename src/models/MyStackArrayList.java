package models;

public class MyStackArrayList<T> {
    private MyArrayList<T> list;

    public MyStackArrayList() {
        list = new MyArrayList<>();
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
