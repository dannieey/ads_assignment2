//for doubly linked list
package models;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {

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

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    private void checkHead() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
    }

    @Override
    public void add(T element) {
        addLast(element);
    }

    @Override
    public void set(int index, T element) {
        checkIndex(index);
        MyNode<T> current = getNode(index);
        current.data = element;
    }

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

    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        checkHead();
        return head.data;
    }

    @Override
    public T getLast() {
        checkHead();
        return tail.data;
    }

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

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

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

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

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
