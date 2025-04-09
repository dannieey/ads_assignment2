import models.MyArrayList;

public class Main {
    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<>();

        //add
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(8);
        list.add(11);
        printList(list);

        //set
        list.set(3,37);
        printList(list);

        //add
        list.add(0,27);
        list.add(6,7);
        printList(list);

        //addFirst
        list.addFirst(938);
        printList(list);

        //addLast
        list.addLast(123);
        printList(list);

        //get
        System.out.println("Element at index 7 is " + list.get(7));

        //getFirst
        System.out.println("the 1st element is " + list.getFirst());

        //getLast
        System.out.println("the last element is " + list.getLast());

        //remove
        System.out.println("Before removing: ");
        printList(list);
        list.remove(5);
        System.out.println("After removing: ");
        printList(list);

        //removeFirst
        list.removeFirst();
        System.out.println("After removing: ");
        printList(list);

        //removeLast
        list.removeLast();
        System.out.println("After removing: ");

        //sort
        list.sort();
        System.out.println("After sorting: ");
        printList(list);

        //indexOf
        System.out.println("Index of 123 is " + list.indexOf(123));
        System.out.println("Index of 1234 is " + list.indexOf(1234));

        //LastIndexOf
        System.out.println("Last index of 8 is " + list.lastIndexOf(8));

        //exists
        System.out.println("Does 123 exist? " + list.lastIndexOf(123));

        //toArray
        Object[] array=list.toArray();
        for(Object object:array){
            System.out.println(object +" ");
        }

        //clear
        list.clear();
        System.out.println("After clearing list: ");
        printList(list);
    }

    private static void printList(MyArrayList<Integer> list){
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}