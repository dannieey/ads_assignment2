package models;

/**
 * Implementation of a Stack using MyArrayList.
 *
 * @param <T> the type of elements in the stack.
 */
public class MyStack<T> {
    private MyArrayList<T> list;

    /**
     * Constructs an empty stack using MyArrayList.
     */
    public MyStack() {
        list = new MyArrayList<>();
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param element the element to push onto the stack.
     */
    public void push(T element) {
        list.addLast(element);
    }

    /**
     * Pops and returns the element at the top of the stack.
     *
     * @return the element at the top of the stack.
     * @throws IndexOutOfBoundsException if the stack is empty.
     */
    public T pop() {
        T top = list.getLast();
        list.removeLast();
        return top;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack.
     * @throws IndexOutOfBoundsException if the stack is empty.
     */
    public T peek() {
        return list.getLast();
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the size of the stack.
     */
    public int size() {
        return list.size();
    }

    /**
     * Clears the stack.
     */
    public void clear() {
        list.clear();
    }
}
