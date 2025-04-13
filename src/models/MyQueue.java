package models;

/**
 * Implementation of a Queue using MyArrayList.
 *
 * @param <T> the type of elements in the queue.
 */
public class MyQueue<T> {
    private MyArrayList<T> list;

    /**
     * Constructs an empty queue using MyArrayList.
     */
    public MyQueue() {
        list = new MyArrayList<>();
    }

    /**
     * Adds an element to the end of the queue.
     *
     * @param element the element to enqueue.
     */
    public void enqueue(T element) {
        list.addLast(element);
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue.
     * @throws IndexOutOfBoundsException if the queue is empty.
     */
    public T dequeue() {
        T front = list.getFirst();
        list.removeFirst();
        return front;
    }

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue.
     * @throws IndexOutOfBoundsException if the queue is empty.
     */
    public T peek() {
        return list.getFirst();
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the size of the queue.
     */
    public int size() {
        return list.size();
    }

    /**
     * Clears the queue.
     */
    public void clear() {
        list.clear();
    }
}
