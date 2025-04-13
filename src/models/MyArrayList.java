package models;

import java.util.Iterator;

/**
 * Implementation of a dynamic array list.
 *
 * @param <T> the type of elements in the list.
 */
public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size;

    /**
     * Constructs an empty MyArrayList with an initial capacity of 10.
     */
    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    /**
     * Ensures that the array has enough capacity to store the current number of elements.
     * Doubles the size of the array if necessary.
     */
    private void checkCapacity() {
        if (size >= elements.length) {
            Object[] temp = new Object[elements.length * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = elements[i];
            }
            elements = temp;
        }
    }

    /**
     * Checks if the specified index is valid.
     *
     * @param index the index to check.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Adds the specified element to the end of the list.
     *
     * @param element the element to add.
     */
    @Override
    public void add(T element) {
        checkCapacity();
        elements[size++] = element;
    }

    /**
     * Sets the element at the specified index to the given element.
     *
     * @param index   the index of the element to replace.
     * @param element the new element.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public void set(int index, T element) {
        checkIndex(index);
        elements[index] = element;
    }

    /**
     * Adds the specified element at the specified index, shifting subsequent elements.
     *
     * @param index   the index to insert at.
     * @param element the element to add.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public void add(int index, T element) {
        checkIndex(index);
        checkCapacity();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * Adds the specified element to the beginning of the list.
     *
     * @param element the element to add.
     */
    @Override
    public void addFirst(T element) {
        checkCapacity();
        for (int i = size; i > 0; i--) {
            elements[i] = elements[i - 1];
        }
        elements[0] = element;
        size++;
    }

    /**
     * Adds the specified element to the end of the list.
     *
     * @param element the element to add.
     */
    @Override
    public void addLast(T element) {
        checkCapacity();
        elements[size] = element;
        size++;
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index the index of the element to retrieve.
     * @return the element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    /**
     * Returns the first element in the list.
     *
     * @return the first element.
     * @throws IndexOutOfBoundsException if the list is empty.
     */
    @Override
    public T getFirst() {
        return (T) elements[0];
    }

    /**
     * Returns the last element in the list.
     *
     * @return the last element.
     * @throws IndexOutOfBoundsException if the list is empty.
     */
    @Override
    public T getLast() {
        return (T) elements[size - 1];
    }

    /**
     * Removes the element at the specified index.
     *
     * @param index the index of the element to remove.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }

    /**
     * Removes the first element in the list.
     */
    @Override
    public void removeFirst() {
        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }

    /**
     * Removes the last element in the list.
     */
    @Override
    public void removeLast() {
        elements[--size] = null;
    }

    /**
     * Sorts the list in ascending order using the elements' natural ordering.
     */
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                Comparable<T> a = (Comparable<T>) elements[i];
                T b = (T) elements[j];
                if (a.compareTo(b) > 0) {
                    Object temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
    }

    /**
     * Returns the index of the first occurrence of the specified object, or -1 if not found.
     *
     * @param object the object to search for.
     * @return the index of the first occurrence, or -1 if not found.
     */
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified object, or -1 if not found.
     *
     * @param object the object to search for.
     * @return the index of the last occurrence, or -1 if not found.
     */
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks if the specified object exists in the list.
     *
     * @param object the object to check.
     * @return true if the object exists, false otherwise.
     */
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    /**
     * Converts the list to an array.
     *
     * @return an array containing the elements of the list.
     */
    @Override
    public Object[] toArray() {
        Object[] temp = new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = elements[i];
        }
        return temp;
    }

    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        elements = new Object[10];
        size = 0;
    }

    /**
     * Returns the size of the list.
     *
     * @return the number of elements in the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over the elements in the list.
     *
     * @return an iterator over the elements.
     */
    @Override
    public Iterator<T> iterator() {
        return null; // Iterator implementation is not provided.
    }
}
