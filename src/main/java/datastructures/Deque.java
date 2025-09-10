package datastructures;

public class Deque {
    private Node head;
    private Node tail;
    private int size;

    /**
     * A node in the deque.
     */
    private class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Add an element to the front of the deque.
     * 
     *
     * @param value the value to add
     */
    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public int removeFirst() {
        if (size == 0) throw new IllegalStateException("Deque is empty");
        int value = head.value;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null; // Deque is now empty
        size--;
        return value;
    }

    public int removeLast() {
        if (size == 0) throw new IllegalStateException("Deque is empty");
        int value = tail.value;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null; // Deque is now empty
        size--;
        return value;
    }

    public int peekFirst() {
        if (size == 0) throw new IllegalStateException("Deque is empty");
        return head.value;
    }

    public int peekLast() {
        if (size == 0) throw new IllegalStateException("Deque is empty");
        return tail.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
