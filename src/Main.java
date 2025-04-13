import models.*;

/**
 * Main class to demonstrate and test all implemented data structures:
 * - MyArrayList
 * - MyLinkedList
 * - MyQueue (using MyArrayList)
 * - MyStack (using MyArrayList)
 * - MyHeap (using MyArrayList)
 */
public class Main {
    public static void main(String[] args) {

        // --- MyArrayList ---
        System.out.println("=== MyArrayList ===");
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10); // add to end
        arrayList.addFirst(5); // add to beginning
        arrayList.addLast(15); // add to end (alternative method)
        arrayList.add(1, 7); // insert at index 1
        printList(arrayList);
        arrayList.set(2, 20); // set value at index 2
        System.out.println("Get index 2: " + arrayList.get(2));
        System.out.println("Get first: " + arrayList.getFirst());
        System.out.println("Get last: " + arrayList.getLast());
        arrayList.remove(1); // remove element at index 1
        arrayList.removeFirst(); // remove first element
        arrayList.removeLast(); // remove last element
        arrayList.sort(); // sort list
        printList(arrayList);
        System.out.println("Index of 10: " + arrayList.indexOf(10));
        System.out.println("Last index of 10: " + arrayList.lastIndexOf(10));
        System.out.println("Exists 10: " + arrayList.exists(10));
        Object[] array = arrayList.toArray(); // convert to array
        for (Object o : array) System.out.print(o + " ");
        System.out.println();
        arrayList.clear(); // clear list
        printList(arrayList);

        // --- MyLinkedList ---
        System.out.println("\n=== MyLinkedList ===");
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1); // add to end
        linkedList.addFirst(0); // add to beginning
        linkedList.addLast(2); // add to end
        linkedList.add(1, 5); // insert at index 1
        printList(linkedList);
        linkedList.set(2, 10); // set value at index 2
        System.out.println("Get index 1: " + linkedList.get(1));
        System.out.println("Get first: " + linkedList.getFirst());
        System.out.println("Get last: " + linkedList.getLast());
        linkedList.remove(1); // remove element at index 1
        linkedList.removeFirst(); // remove first element
        linkedList.removeLast(); // remove last element
        linkedList.sort(); // sort list
        printList(linkedList);
        System.out.println("Index of 10: " + linkedList.indexOf(10));
        System.out.println("Last index of 10: " + linkedList.lastIndexOf(10));
        System.out.println("Exists 10: " + linkedList.exists(10));
        Object[] linkedArr = linkedList.toArray(); // convert to array
        for (Object o : linkedArr) System.out.print(o + " ");
        System.out.println();
        linkedList.clear(); // clear list
        printList(linkedList);

        // --- MyQueue (ArrayList) ---
        System.out.println("\n=== MyQueue (ArrayList) ===");
        MyQueue<Integer> queueArray = new MyQueue<>();
        queueArray.enqueue(1); // enqueue element
        queueArray.enqueue(2);
        System.out.println("Dequeue: " + queueArray.dequeue()); // dequeue element
        System.out.println("Peek: " + queueArray.peek()); // peek at front
        System.out.println("Size: " + queueArray.size());
        System.out.println("Is empty: " + queueArray.isEmpty());
        queueArray.clear(); // clear queue
        System.out.println("Size after clear: " + queueArray.size());

        // --- MyStack (ArrayList) ---
        System.out.println("\n=== MyStack (ArrayList) ===");
        MyStack<Integer> stackArray = new MyStack<>();
        stackArray.push(10); // push onto stack
        stackArray.push(20);
        System.out.println("Pop: " + stackArray.pop()); // pop from stack
        System.out.println("Peek: " + stackArray.peek()); // peek at top
        System.out.println("Size: " + stackArray.size());
        System.out.println("Is empty: " + stackArray.isEmpty());
        stackArray.clear(); // clear stack
        System.out.println("Size after clear: " + stackArray.size());

        // --- MyHeap (ArrayList) ---
        System.out.println("\n=== MyHeap (ArrayList) ===");
        MyHeap<Integer> heapArray = new MyHeap<>();
        heapArray.insert(9); // insert into heap
        heapArray.insert(3);
        heapArray.insert(5);
        System.out.println("PeekMin: " + heapArray.peekMin()); // peek min element
        System.out.println("RemoveMin: " + heapArray.removeMin()); // remove min element
        System.out.println("Is empty: " + heapArray.isEmpty());
        System.out.println("Size: " + heapArray.size());
        heapArray.clear(); // clear heap
        System.out.println("Size after clear: " + heapArray.size());
    }

    /**
     * Utility method to print elements of a list (MyArrayList or MyLinkedList).
     */
    private static void printList(MyList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}