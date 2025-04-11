package models;

public class MyStackArrayList<E> {
    private MyArrayList<E> list;

    public MyStackArrayList() {
        list=new MyArrayList<>();
    }

    public void push(E element){
        list.addLast(element);
    }

    public E pop(){
        if(list.size()==0){
            throw new IllegalStateException("Stack is empty");
        }
        return list.removeLast();
    }

    public E peek(){
       if(list.size()==0){
           throw new IllegalStateException("Stack is empty");
       }
       return list.getLast();
    }

    public boolean isEmpty(){
        return list.size()==0;
    }
}
