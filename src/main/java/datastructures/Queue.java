package datastructures;

public class Queue {

    /*
    1. Use Linked List
    2. Enqueue -> Add node at the last of the list
    3. Dequeue -> Remove node from the beginning of the list
    4. FIFO as the node that is added first moves to the beginning
       as more nodes are added and the first node is removed during dequeue operation.
    5. This way all operations are O(1)
     */
    private Node first;
    private Node last;
    private int length;

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    public void printQueue() {
        if(first==null) {
            System.out.println("Queue is Empty");
        } else {
            Node temp = first;
            System.out.print("first -> ");
            while(temp.next!=null) {
                System.out.print(temp.value+" -> ");
                temp=temp.next;
            }
            System.out.print("last");
            System.out.println();
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("First: null");
            System.out.println("Last: null");
        } else {
            System.out.println("First: " + first.value);
            System.out.println("Last: " + last.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nQueue:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printQueue();
        }
    }

    public void makeEmpty() {
        first = null;
        last = null;
        length = 0;
    }

    /**
     * Enqueue - Adding a node to the end of the queue
     * @param value
     */
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    /**
     * Dequeue - Removing a node from the beginning of the queue
     * @return
     */
    public Node dequeue() {
        if(length==0) return null;
        Node temp;
        if(length==1) {
            temp = first;
            first = null;
            last = null;
        } else {
            temp = first;
            first = temp.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.enqueue(11);
        queue.enqueue(12);
        queue.enqueue(13);
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
    }
}