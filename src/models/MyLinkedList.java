//for doubly linked list
package models;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a doubly linked list.
 * Supports adding, removing, sorting, and iterating over elements.
 *
 * @param <T> Type of elements in the list.
 */
public class MyLinkedList<T> implements MyList<T> {

    /**
     * Node of the doubly linked list.
     * Contains data and pointers to the next and previous nodes.
     */
    private class MyNode<E> {
        E data;
        MyNode<E> next;
        MyNode<E> prev;

        MyNode(E data) {
            this.data = data;
        }
    }

    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    /**
     * Constructor for an empty list.
     * Initializes the list with no elements.
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Checks if the given index is valid for the list.
     *
     * @param index The index to check.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /**
     * Checks if the list is empty.
     *
     * @throws NoSuchElementException if the list is empty.
     */
    private void checkHead() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
    }

    /**
     * Adds an element to the end of the list (alias for addLast).
     *
     * @param element The element to add.
     */
    @Override
    public void add(T element) {
        addLast(element);
    }

    /**
     * Replaces the element at the specified index with a new element.
     *
     * @param index   The index of the element to replace.
     * @param element The new element.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public void set(int index, T element) {
        checkIndex(index);
        MyNode<T> current = getNode(index);
        current.data = element;
    }

    /**
     * Adds an element at the specified index.
     *
     * @param index   The index at which to add the element.
     * @param element The element to add.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public void add(int index, T element) {
        if (index == size) {
            addLast(element);
            return;
        }
        checkIndex(index);
        MyNode<T> newNode = new MyNode<>(element);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            MyNode<T> current = getNode(index);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    /**
     * Adds an element to the beginning of the list.
     *
     * @param element The element to add.
     */
    @Override
    public void addFirst(T element) {
        MyNode<T> newNode = new MyNode<>(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element The element to add.
     */
    @Override
    public void addLast(T element) {
        MyNode<T> newNode = new MyNode<>(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Retrieves the element at the specified index.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    /**
     * Retrieves the first element of the list.
     *
     * @return The first element of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    @Override
    public T getFirst() {
        checkHead();
        return head.data;
    }

    /**
     * Retrieves the last element of the list.
     *
     * @return The last element of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    @Override
    public T getLast() {
        checkHead();
        return tail.data;
    }

    /**
     * Removes the element at the specified index.
     *
     * @param index The index of the element to remove.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        MyNode<T> current = getNode(index);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }

    /**
     * Removes the first element of the list.
     *
     * @throws NoSuchElementException if the list is empty.
     */
    @Override
    public void removeFirst() {
        checkHead();
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    /**
     * Removes the last element of the list.
     *
     * @throws NoSuchElementException if the list is empty.
     */
    @Override
    public void removeLast() {
        checkHead();
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    /**
     * Sorts the elements of the list using bubble sort.
     */
    @Override
    public void sort() {
        if (size <= 1) return;
        boolean swapped;
        do {
            swapped = false;
            MyNode<T> current = head;
            while (current.next != null) {
                if (((Comparable<T>) current.data).compareTo(current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    /**
     * Finds the index of the first occurrence of an object in the list.
     *
     * @param object The object to find.
     * @return The index of the first occurrence, or -1 if not found.
     */
    @Override
    public int indexOf(Object object) {
        MyNode<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(object)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    /**
     * Finds the index of the last occurrence of an object in the list.
     *
     * @param object The object to find.
     * @return The index of the last occurrence, or -1 if not found.
     */
    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.data.equals(object)) return index;
            current = current.prev;
            index--;
        }
        return -1;
    }

    /**
     * Checks if the list contains the given object.
     *
     * @param object The object to check for.
     * @return true if the object exists in the list, false otherwise.
     */
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    /**
     * Converts the list to an array.
     *
     * @return An array containing all the elements of the list.
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode<T> current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    /**
     * Clears the list, removing all elements.
     */
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * Returns the size of the list.
     *
     * @return The number of elements in the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Retrieves the node at the specified index.
     *
     * @param index The index of the node.
     * @return The node at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    private MyNode<T> getNode(int index) {
        checkIndex(index);
        MyNode<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    /**
     * Returns an iterator for the list.
     *
     * @return An iterator for the list.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode<T> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}



//for singly linked list

//package models;
//
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//public class MyLinkedList<T> implements MyList<T> {
//
//    private MyNode<T> head;
//    private int length;
//
//    public MyLinkedList(){
//        head=null;
//        length=0;
//    }
//
//    @Override
//    public void add(T element) {
//        MyNode<T> newNode = new MyNode<>(element);
//        if(head==null){
//            head=newNode;
//        }
//        else{
//            MyNode<T> current =head; //current указывает на head, а не принимает его значение, при помощи него мы сможем свободно ходить по узлам
//            while(current.next!=null){
//                current=current.next;
//            }
//            current.next=newNode; // current=null -> добавляем новый узел
//        }
//        length++; //увеличиваем длину из-за того что добавили новый узел
//
//    }
//
//    @Override
//    public void set(int index, T element) {
//        checkIndex(index);
//        MyNode<T> current=head;
//        for(int i=0; i<index; i++){
//            current=current.next;
//        }
//        current.data=element;
//    }
//
//
//
//    public void checkIndex(int index){
//        if(index<0||index>=length){
//            throw new IndexOutOfBoundsException("Index out of bounds");
//        }
//    }
//
//    @Override
//    public void add(int index, T element) {
//        checkIndex(index);
//        MyNode<T> newNode = new MyNode<>(element);
//
//        if(index==0){
//            newNode.next=head;
//            head=newNode;
//        }
//        else{
//            MyNode<T> current =head;
//            for(int i=0; i<index; i++){
//                current=current.next;
//            }
//            newNode.next=current.next; // новый узел теперь будет указывать на тот, кто раньше шел после current
//            current.next=newNode; //current указывает на newNode новый узел
//        }
//
//        length++;
//
//
//    }
//
//    @Override
//    public void addFirst(T element) {
//        MyNode<T> newNode=new MyNode<>(element);
//        newNode=head;
//        head=newNode;
//        length++;
//
//    }
//
//    @Override
//    public void addLast(T element) {
//        MyNode<T> newNode = new MyNode<>(element);
//        if(head==null){
//            head=newNode;
//        }
//        else{
//            MyNode<T> current=head;
//            while(current.next!=null){
//                current=current.next;
//            }
//            current.next=newNode;
//        }
//        length++;
//        //or just add(element)
//
//    }
//
//    @Override
//    public T get(int index) {
//        checkIndex(index);
//        MyNode<T> current=head;
//        for(int i=0; i<index; i++){
//            current=current.next;
//        }
//        return current.data;
//
//    }
//
//    @Override
//    public T getFirst()  {
//        checkHead();
//        return head.data;
//    }
//
//    @Override
//    public T getLast() {
//        checkHead();
//        MyNode<T> current=head;
//        while(current.next!=null){
//            current=current.next;
//        }
//        return current.data;
//    }
//
//    @Override
//    public void remove(int index) {
//        checkIndex(index);
//        if(index==0){
//            head=head.next;
//        }
//        else {
//            MyNode<T> current = head;
//            for (int i = 0; i < index; i++) {
//                current = current.next;
//            }
//            current.next = current.next.next;
//        }
//        length--;
//    }
//
//    @Override
//    public void removeFirst() {
//        checkHead();
//        head=head.next;
//        length--;
//
//    }
//    public void checkHead(){
//        if(head==null){
//            throw new NoSuchElementException("empty");
//        }
//    }
//
//    @Override
//    public void removeLast() {
//        checkHead();
//        if(head.next==null){ //если тоолько один элемент, удаляем его сразк
//            head=null;
//        }
//        else{
//            MyNode<T> current=head;
//            while(current.next!=null && current.next.next!=null ){
//                current=current.next;
//
//            }
//            current.next=null;
//        }
//        length--;
//
//    }
//
//    @Override
//    public void sort() {
//        if(head==null || head.next==null){
//            return;
//        }
//        boolean swap;
//        do{
//            swap=false;
//            MyNode<T> current=head;
//            while(current!=null && current.next!=null){
//                if(((Comparable<T>)current.data). compareTo(current.next.data)>0){
//                    T temp=current.data;
//                    current.data=current.next.data;
//                    current.next.data=temp;
//                    swap=true;
//                }
//                current=current.next;
//            }
//        }
//        while(swap);
//
//    }
//
//    @Override
//    public int indexOf(Object object) {
//        MyNode<T> current=head;
//        int index=0;
//        while(current!=null){
//            if(current.data.equals(object)){
//                return index;
//            }
//            current=current.next;
//            index++;
//        }
//        return -1;
//
//    }
//
//    @Override
//    public int lastIndexOf(Object object) {
//        MyNode<T> current=head;
//        int index=-1; //не найден
//
//        int i=0;
//        while(current!=null){
//            if(current.data.equals(object)){
//                index=i;
//            }
//            current=current.next;
//            i++;
//        }
//        return index;
//    }
//
//    @Override
//    public boolean exists(Object object) {
//        return indexOf(object)!=-1;
//
//    }
//
//    @Override
//    public Object[] toArray() {
//        Object[] arr=new Object[length]; //создаем массив нужной длины
//        MyNode<T> current=head;
//        int i=0;
//        while(current!=null){
//            arr[i++]=current.data;
//            current=current.next;
//        }
//        return arr;
//
//    }
//
//    @Override
//    public void clear() {
//        head=null;
//        length=0;
//
//    }
//
//    @Override
//    public int size() {
//        return length;
//    }
//
//    @Override
//    public Iterator<T> iterator() {
//        return null;
//    }
//}
