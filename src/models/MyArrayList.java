package models;

public class MyArrayList<T> implements MyList<T>{
    private Object[] elements;
    private int size;

    public MyArrayList(){
        elements=new Object[10];
        size=0;
    }



    private void checkCapacity(){
        if(size>elements.length){
            Object[] temp = new Object[elements.length*2];
            for(int i=0; i<size; i++){
                temp[i]=elements[i];
            }
            elements=temp; //or temp=elements
        }
    }


    private void checkIndex(int index){
        if(index<0 || index > elements.length){
            throw new IndexOutOfBoundsException();
        }

    }

    public void add(T element){
        checkCapacity();
        elements[size++]=element;
    }

    public void set(int index, T element){
        checkIndex(index);
        elements[index]= element;

    }


    public void add(int index, T element){
        checkIndex(index);
        checkCapacity();
        for(int i=size; i>index; i--){
            elements[i]=elements[i-1];
        }
        elements[index]=element;
        size++;
    }

    public void addFirst(T element){
        checkCapacity();
        for(int i=size; i>0; i--){
            elements[i]=elements[i-1];
        }
        elements[0]=element;
        size++;
    }
    public void addLast(T element){
        checkCapacity();
        elements[size]=element;
        size++;

    }
    public T get(int index){
        checkIndex(index);
        return (T) elements[index];

    }
    public T getFirst(){
        return (T)elements[0];
    }
    public T getLast(){

        return (T) elements[size-1];
    }



    public T remove(int index){
        checkIndex(index);
        //1 2 3 4 5 /--> 1 2 4 5
        for(int i=index; i<size-1; i++){
            elements[i]=elements[i+1];
        }
        elements[--size]=null;
        return null;
    }

    public T removeFirst(){
        for(int i=0; i<size-1; i++){
            elements[i]=elements[i+1];
        }
        return null;
    }
    public T removeLast(){
        checkCapacity();
        elements[size-1]=null;
        return null;
    }


    public void sort(){
        for(int i=0; i<size-1; i++){
            for(int j=i+1; j<size; j++){
                Comparable<T> a =(Comparable<T>) elements[i];
                T b=(T) elements[j];
                if(a.compareTo(b)>0){
                    Object temp=elements[i];
                    elements[i]=elements[j];
                    elements[j]=temp;
                }

            }
        }
    }



    public int indexOf(Object object) {
        for(int i=0; i<size; i++){
            if(elements[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        for(int i=size-1; i>=0; i--){
            if(elements[i].equals(object)){
                return i;
            }
        }
        return -1;
    }
    public boolean exists(Object object){
        return indexOf(object)!=-1;
    }
    public Object[] toArray(){
        Object[] temp =new Object[size];
        for(int i=0; i<size; i++){
            temp[i]=elements[i];
        }
        return temp;
    }

    public void clear(){
        elements=new Object[10];
        size=0;
    }
    public int size(){
        return size;
    }





}
