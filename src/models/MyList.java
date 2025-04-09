package models;
public interface MyList<T> {
   void add(T element);
   void set(int index, T element);
   void add(int index, T element);
   void addFirst(T element);
   void addLast(T element);
   T get(int index);
   T getFirst();
   T getLast();
   T remove(int index);
   T removeFirst();
   T removeLast();
   void sort();
   int indexOf(Object object);
   int lastIndexOf(Object object);
   boolean equals(Object object);
   public Object[] toArray();
   void clear();
   int size();


}