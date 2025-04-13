package models;

/**
 * Implementation of a Min-Heap using MyArrayList.
 *
 * @param <T> the type of elements in the heap, which must be Comparable.
 */
public class MyHeap<T extends Comparable<T>> {
    private MyArrayList<T> list;

    /**
     * Constructs an empty heap using MyArrayList.
     */
    public MyHeap() {
        list = new MyArrayList<>();
    }

    /**
     * Inserts an element into the heap and sorts the list.
     *
     * @param element the element to insert into the heap.
     */
    public void insert(T element) {
        list.add(element);
        list.sort(); // Simple sort after insertion
    }

    /**
     * Returns the minimum element in the heap without removing it.
     *
     * @return the minimum element in the heap.
     * @throws IndexOutOfBoundsException if the heap is empty.
     */
    public T peekMin() {
        return list.getFirst();
    }

    /**
     * Removes and returns the minimum element from the heap.
     *
     * @return the minimum element from the heap.
     * @throws IndexOutOfBoundsException if the heap is empty.
     */
    public T removeMin() {
        T min = list.getFirst();
        list.removeFirst();
        return min;
    }

    /**
     * Checks if the heap is empty.
     *
     * @return true if the heap is empty, false otherwise.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * Returns the number of elements in the heap.
     *
     * @return the size of the heap.
     */
    public int size() {
        return list.size();
    }

    /**
     * Clears the heap.
     */
    public void clear() {
        list.clear();
    }
}
