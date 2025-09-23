package datastructures;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Initializes a new linked list with a single node containing the specified value.
     * The head and tail pointers both point to this new node, and the length of the list is set to 1.
     * 
     * @param value the value to be stored in the initial node of the linked list
     */
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    /**
     * Returns the head node of the linked list.
     *
     * @return the head node of the linked list
     */
    public Node getHead() {
        return head;
    }

    /**
     * Returns the tail node of the linked list.
     *
     * @return the tail node of the linked list
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Returns the length of the linked list.
     * 
     * @return the length of the linked list
     */
    public int getLength() {
        return length;
    }

    /**
     * Prints the linked list in a readable format, showing the sequence of node values from head to tail.
     * Each node's value is followed by an arrow ("->") to indicate the 
     * link to the next node, ending with "null" to signify the end of the list.
     * Example output: "3 -> 5 -> 7 -> null"    
     */
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print(" null ");
        System.out.println();
    }

    /**
     * Prints all relevant information about the linked list, including the head, tail, length, and the list itself.
     */
    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    /**
     * Empties the linked list by removing all nodes and resetting the head, tail, and length.
     */
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    /**
     * Appends a new node with the specified value to the end of the linked list.
     * If the list is empty, the new node becomes both the head and tail of the list.
     * Otherwise, it is added after the current tail, and the tail pointer is updated.
     * The length of the list is incremented by 1.
     * 
     * @param value the value to be stored in the new node
     * @return the updated linked list
     */
    public LinkedList append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
        return this;
    }

    /**
     * Removes the last node from the linked list and returns it.
     *
     * @return the removed node, or null if the list is empty
     */
    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while(temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    /**
     * Prepends a new node with the specified value to the beginning of the linked list.
     * If the list is empty, the new node becomes both the head and tail of the list.
     * Otherwise, it is added before the current head, and the head pointer is updated.
     * The length of the list is incremented by 1.
     * 
     * @param value the value to be stored in the new node
     * @return the updated linked list
     */
    public LinkedList prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
        return this;
    }

    /**
     * Removes the first node from the linked list and returns it.
     * If the list is empty, it returns null.
     * The head pointer is updated to the next node, and the length of the list is decremented by 1.
     * If the list becomes empty after removal, the tail pointer is also set to null.
     *
     * @return the removed node, or null if the list is empty
     */
    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    /**
     * Retrieves the node at the specified index in the linked list.
     * If the index is out of bounds (less than 0 or greater than or equal to the length of the list), it returns null.
     * Otherwise, it iterates through the list to find and return the node at the given index.
     *
     * @param index the index of the node to retrieve
     * @return the node at the specified index, or null if the index is out of bounds
     */
    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * Updates the value of the node at the specified index in the linked list.
     * If the index is valid, it sets the node's value to the provided value and returns true.
     * If the index is out of bounds, it returns false.
     *
     * @param index the index of the node to update
     * @param value the new value to set for the node
     * @return true if the node was updated successfully, false if the index is out of bounds
     */
    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    /**
     * Inserts a new node with the specified value at the given index in the linked list.
     * If the index is 0, it prepends the new node to the beginning of the list.
     * If the index is equal to the length of the list, it appends the new node to the end of the list.
     * If the index is out of bounds (less than 0 or greater than the length), it returns false.
     * Otherwise, it inserts the new node at the specified index and returns true.
     *
     * @param index the index at which to insert the new node
     * @param value the value to be stored in the new node
     * @return true if the node was inserted successfully, false if the index is out of bounds
     */
    public boolean insert(int index, int value)  {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    /**
     * Removes the node at the specified index from the linked list and returns it.
     * If the index is 0, it removes the first node.
     * If the index is equal to the length minus one, it removes the last node.
     * If the index is out of bounds (less than 0 or greater than or equal to the length), it returns null.
     * Otherwise, it removes the node at the specified index and returns it.
     *
     * @param index the index of the node to remove
     * @return the removed node, or null if the index is out of bounds
     */
    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    /**
     * Reverses the linked list in place by iterating through the list and reversing the direction of the next pointers.
     * The head and tail pointers are swapped, and the next pointers of each node are updated to point to the previous node.
     * This process continues until all nodes have been processed, resulting in a reversed linked list.
     * Time Complexity: O(n), where n is the number of nodes in the linked list.
     * Space Complexity: O(1), as the reversal is done in place without using any additional data structures.
     */
    public void reverse() {
        // Set temp to the current head of the linked list
        Node temp = head;
        // Set the new head to be the current tail
        head = tail;
        // Set the new tail to be the previous head (stored in temp)
        tail = temp;

        // Set after to be the next node after the current head
        Node after;
        // Initialize before to null, as the first node in the reversed list will not have a previous node
        Node before = null;

        // Loop through the linked list, reversing the order of the nodes
        while(temp!=null) {
            // Set after to be the next node after the current node
            after = temp.next;
            // Set the current node's next pointer to the previous node
            temp.next = before;
            // Set before to be the current node, as it will be the previous node in the next iteration of the loop
            before = temp;
            // Set temp to be the next node in the linked list
            temp = after;
        }
    }

    /**
     * Finds the middle node of the linked list using the two-pointer technique.
     * The slow pointer moves one step at a time, while the fast pointer moves two steps at a time.
     * When the fast pointer reaches the end of the list, the slow pointer will be at the middle node.
     * @return The Node object representing the middle node of the linked list.
     */
    public Node findMiddleNode() {
        // Initialize slow pointer to the head of the linked list
        Node slow = head;

        // Initialize fast pointer to the head of the linked list
        Node fast = head;

        // Traverse the linked list with two pointers: slow and fast
        // slow moves one node at a time, while fast moves two nodes at a time
        while (fast != null && fast.next != null) {
            // Move slow pointer to the next node
            slow = slow.next;

            // Move fast pointer to the next two nodes
            fast = fast.next.next;
        }

        // Return the Node object representing the middle node of the linked list
        return slow;
    }

    /**
     * Detects if the linked list has a loop (cycle) and returns the node where the cycle begins.
     * 1. Uses Floyd's Cycle-Finding Algorithm (Tortoise and Hare algorithm) to detect the cycle.
     * 2. If a cycle is detected, it finds the starting node of the cycle by
     *    moving one pointer to the head and keeping the other at the meeting point,
     *    then moving both pointers one step at a time until they meet.
     * 3. If no cycle is detected, it returns null.
     * 
     * Time Complexity: O(n), where n is the number of nodes in the linked list.
     * Space Complexity: O(1), as it uses only a constant amount of extra space
     * 
     * @return The Node object where the cycle begins, or null if there is no cycle.
     */
    public Node detectLoopNode() {
        // Initialize slow and fast pointers to the head of the linked list
        Node slow = head;
        Node fast = head;

        // Move slow pointer one step at a time and fast pointer two steps at a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null; // No cycle

        Node finder = head;
        while (finder != slow) {
            finder = finder.next;
            slow = slow.next;
        }
        return finder;
    }

    /**
     * Below is the intution behind the algorithm:
     * 1. We have two pointers, slow and fast.
     * 2. We move the fast pointer k steps ahead.
     * 3. Then we move both pointers one step at a time until the fast pointer
     *    reaches the end of the list which means the fast pointer has moved n-k steps. 
     * 4. At that point, the slow pointer has moved n-k steps as well from the beginning, 
     *    so it is at the kth node from the end because n-(n-k) = k.
     * @param k the position from the end of the linked list
     * @return The Node object representing the kth node from the end of the linked list.
     */
    public Node findKthFromEnd(int k) {
        Node slow = head; // Initialize slow pointer at head
        Node fast = head; // Initialize fast pointer at head

        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) { // If k is out of bounds, return null
                return null;
            }
            fast = fast.next; // Move the fast pointer to the next node
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next; // Move the slow pointer to the next node
            fast = fast.next; // Move the fast pointer to the next node
        }

        return slow; // Return the kth node from the end (slow pointer)
    }

    /**
     * Removes duplicate values from the linked list using a hash table to track seen values.
     * Iterates through the linked list, checking if each value has been seen before.
     * If a value is a duplicate, it is removed by adjusting the next pointer of the
     * previous node to skip the current node.
     * Time Complexity: O(n), where n is the number of nodes in the linked list.
     * Space Complexity: O(n), as it uses a hash table to store seen values.
     */
    public void removeDuplicates() {
        HashSet<Integer> hashSet = new HashSet<>();
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            // Check if the element is already in the hash table
            if (hashSet.contains(curr.value)) {
                // Element is present, remove it
                prev.next = curr.next;
            } else {
                // Element is not present, add it to hash table
                hashSet.add(curr.value);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    /**
     * Merges the current linked list with another sorted linked list.
     * 1. The method iterates through both linked lists, comparing the values of their nodes,
     *    and appending the smaller node to the merged list. It continues this process until
     *    all nodes from both lists have been processed. If one list is exhausted before the other,
     *    the remaining nodes from the non-exhausted list are appended to the end of the merged list.
     * 2. The head and tail pointers of the current list are updated to reflect the merged list,
     *    and the length is adjusted accordingly.
     * 
     * Time Complexity: O(n + m), where n and m are the lengths of the two linked lists.
     * Space Complexity: O(1), as the merging is done in place without using any additional data structures.
     * 
     * @param otherList
     */
    public void merge(LinkedList otherList) {
        // get the head node of the other linked list
        Node otherHead = otherList.getHead();
        // create a dummy node to serve as the head of the merged linked list
        Node dummy = new Node(0);
        // create a current node to keep track of the last node in the merged list
        Node current = dummy;

        // iterate through both input linked lists as long as they are not null
        while (head != null && otherHead != null) {
            // compare the values of the head nodes of the two lists
            if (head.value < otherHead.value) {
                // append the smaller node to the merged list and
                //update the head of that list to its next node
                current.next = head;
                head = head.next;
            } else {
                // append the smaller node to the merged list and
                //update the head of that list to its next node
                current.next = otherHead;
                otherHead = otherHead.next;
            }
            // update the "current" node to be the last node in the merged list
            current = current.next;
        }

        // if either of the input lists still has nodes,
        // append them to the end of the merged list
        if (head != null) {
            current.next = head;
        } else {
            current.next = otherHead;
            // If current list is empty, update tail to last node of other list
            // Otherwise, tail remains the last node of the current list
            tail = otherList.getTail();
        }

        // update the head of the current list to be the second node
        // in the merged list (since the first node is the dummy node)
        head = dummy.next;
        // update the length of the current list to reflect the merged list
        length += otherList.getLength();
    }

    /**
     * Merges two sorted linked lists into a single sorted linked list using a min-heap (priority queue).
     * 1. The method initializes a min-heap and adds the head nodes of both linked lists to it.
     * 2. It then repeatedly extracts the smallest node from the heap, appending it to the merged list,
     *    and adds the next node from the extracted node's list to the heap if it exists.
     * 3. This process continues until all nodes from both lists have been processed.
     * 4. The method returns the head of the merged linked list.
     * 
     * Time Complexity: O((n + m) log(n + m)), where n and m are the lengths of the two linked lists.
     * Space Complexity: O(n + m), as the min-heap can contain up to n + m nodes.
     * 
     * @param otherList the other sorted linked list to merge with
     * @return The head node of the merged sorted linked list.
     */
    public Node mergeUsingMinHeap(LinkedList otherList) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.value));
        // Add the head of each list to the min-heap if not null
        if (this.head != null) minHeap.offer(this.head);
        if (otherList.head != null) minHeap.offer(otherList.head);

        Node dummy = new Node(0);
        Node current = dummy;

        while (!minHeap.isEmpty()) {
            Node minNode = minHeap.poll();
            current.next = minNode;
            current = current.next;
            // If the polled node has a next, add it to the heap
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }
        return dummy.next;
    }

    /**
     * Partitions the linked list into two parts: values less than x
     * and values greater than or equal to x.
     * The original relative order of the nodes in each partition is preserved.
     * 1. The method creates two dummy nodes to serve as the heads of the two partitions.
     * 2. It iterates through the original linked list, adding each node to
     *    the appropriate partition based on its value relative to x.
     * 3. After processing all nodes, it connects the two partitions and updates
     *    the head of the original list to point to the start of the first partition.
     * Time Complexity: O(n), where n is the number of nodes in the linked list.
     * @param x the partition value
     */
    /*
    Linked List  3 -> 8 -> 5 -> 10 -> 2 -> 1
    First Partition  0 -> 3 -> 2 -> 1
    Second Partition 0 -> 8 -> 5 -> 10
    Combined 3 -> 2 -> 1 -> 8 -> 5 -> 10
     */
    public void partitionList(int x) {
        // Step 1: Check for an empty list.
        // If the list is empty, there is nothing
        // to partition, so we exit the method.
        if (head == null) return;

        // Step 2: Create two dummy nodes.
        // These dummy nodes act as placeholders
        // to simplify list manipulation.
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        // Step 3: Initialize pointers for new lists.
        // 'prev1' and 'prev2' will track the end nodes of
        // the two lists that are being created.
        Node prev1 = dummy1;
        Node prev2 = dummy2;

        // Step 4: Start with the head of the original list.
        Node current = head;

        // Step 5: Iterate through the original list.
        while (current != null) {

            // Step 6: Compare current node value with 'x'.
            // Nodes are partitioned based on their value
            // being less than or greater than/equal to 'x'.

            // Step 6.1: If value is less than 'x',
            // add node to the first list.
            if (current.value < x) {
                prev1.next = current;  // Link node to the end of the first list.
                prev1 = current;       // Update the end pointer of the first list.
            } else {
                // Step 6.2: If value is greater or equal,
                // add node to the second list.
                prev2.next = current;  // Link node to the end of the second list.
                prev2 = current;       // Update the end pointer of the second list.
            }

            // Move to the next node in the original list.
            current = current.next;
        }

        // Step 7: Terminate the second list.
        // This prevents cycles in the list.
        prev2.next = null;

        // Step 8: Connect the two lists.
        // The first list is followed by the second list.
        prev1.next = dummy2.next;

        // Step 9: Update the head of the original list.
        // The head now points to the start of the first list.
        head = dummy1.next;
    }

    /**
     * Reverses a section of the linked list between the specified start and end indices (inclusive).
     * 1. The method first checks if the linked list is empty. If it is, it exits without making any changes.
     * 2. A dummy node is created to simplify edge cases, such as reversing from the head of the list.
     * 3. The method navigates to the node just before the start index and marks the beginning of the sublist to be reversed.
     * 4. It then iteratively reverses the nodes in the specified range by adjusting the next pointers.
     * 5. Finally, it updates the head of the linked list if the reversal included the first node.
     * Time Complexity: O(n), where n is the number of nodes in the linked list.
     * Space Complexity: O(1), as the reversal is done in place without using any additional data structures.
     * 
     * @param startIndex the starting index of the section to be reversed
     * @param endIndex the ending index of the section to be reversed
     */
    public void reverseBetween(int startIndex, int endIndex) {
        // Check: If linked list is empty, nothing to reverse.
        // Exit the method.
        if (head == null) return;

        // Create a 'dummyNode' that precedes the head.
        // Simplifies handling edge cases.
        Node dummyNode = new Node(0);
        dummyNode.next = head;

        // 'previousNode' is used to navigate to the node
        // right before our sublist begins.
        Node previousNode = dummyNode;

        // Move 'previousNode' to node just before sublist.
        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        // 'currentNode' marks the first node of sublist.
        Node currentNode = previousNode.next;

        // Loop reverses the section from startIndex to endIndex.
        for (int i = 0; i < endIndex - startIndex; i++) {

            // 'nodeToMove' is the node we'll move to sublist start.
            Node nodeToMove = currentNode.next;

            // Detach 'nodeToMove' from its current position.
            currentNode.next = nodeToMove.next;

            // Attach 'nodeToMove' at the beginning of the sublist.
            nodeToMove.next = previousNode.next;

            // Move 'nodeToMove' to the start of our sublist.
            previousNode.next = nodeToMove;
        }

        // Adjust 'head' if the first node was part of sublist.
        head = dummyNode.next;
    }

    /**
     * Swaps every two adjacent nodes in the linked list.
     * 1. The method uses a dummy node to simplify edge cases, such as swapping the first pair of nodes.
     * 2. It iterates through the linked list, swapping pairs of nodes by adjusting their next pointers.
     * 3. The process continues until all pairs have been swapped.
     * 4. Finally, it updates the head of the linked list to point to the new first node.
     * Time Complexity: O(n), where n is the number of nodes in the linked list.
     * Space Complexity: O(1), as the swapping is done in place without using any additional data structures.
     */
    public void swapPairs() {

        // Create a dummy node pointing to the head
        // This simplifies edge cases, like swapping the first pair
        Node dummy = new Node(0);
        dummy.next = head;

        // previous tracks the node before the current pair
        Node previous = dummy;

        // first is the first node in the pair to be swapped
        Node first = head;

        // Loop while there are at least two nodes to swap
        while (first != null && first.next != null) {

            // second is the second node in the pair
            Node second = first.next;

            // Point previous to second, starting the swap
            previous.next = second;

            // Point first to the node after the second
            first.next = second.next;

            // Point second to first, completing the swap
            second.next = first;

            // Move previous to first (end of swapped pair)
            previous = first;

            // Move first to the next pair's first node
            first = first.next;
        }

        // Reset head to point to the new start of the list
        head = dummy.next;
    }

    /**
     * Checks if the linked list is a palindrome.
     * 1. The method first finds the middle of the linked list using the slow and fast pointer technique.
     * 2. It then reverses the second half of the linked list.
     * 3. Finally, it compares the values of the nodes in the first half with the values in the reversed second half.
     * 
     * If all corresponding values match, the linked list is a palindrome.
     * Time Complexity: O(n), where n is the number of nodes in the linked list.
     * Space Complexity: O(1), as the palindrome check is done in place without using any additional data structures.
     * @return true if the linked list is a palindrome, false otherwise
     */
    public boolean isPalindrome() {
        if (head == null || head.next == null) return true;

        // Step 1: Find the middle of the linked list
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        Node prev = null;
        Node current = slow;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // Step 3: Compare the first half and the reversed second half
        Node left = head;
        Node right = prev; // 'prev' is now the head of the reversed second half
        while (right != null) {
            if (left.value != right.value) {
                return false; // Values do not match, not a palindrome
            }
            left = left.next;
            right = right.next;
        }

        return true; // All values matched, it is a palindrome
    }

    public void insertionSort() {
        // If the list has less than 2 elements, it is already sorted
        if (length < 2) {
            return;
        }

        // Start with a sorted list containing only the first element
        Node sortedListHead = head;

        // Start with the second element in the unsorted list
        Node unsortedListHead = head.next;

        // Mark the end of the sorted list
        sortedListHead.next = null;

        // Iterate over the unsorted list
        while (unsortedListHead != null) {

            // Take the first element in the unsorted list
            Node current = unsortedListHead;

            // Move to the next element in the unsorted list
            unsortedListHead = unsortedListHead.next;

            // If the current element is smaller than the first element of the sorted list
            if (current.value < sortedListHead.value) {
                // Insert the current element at the beginning of the sorted list
                current.next = sortedListHead;
                // Update the sorted list head
                sortedListHead = current;
            } else {
                // Start at the beginning of the sorted list
                Node searchPointer = sortedListHead;

                // Search for the correct insertion point
                while (searchPointer.next != null && current.value > searchPointer.next.value) {
                    // Move to the next element in the sorted list
                    searchPointer = searchPointer.next;
                }

                // Insert the current element after searchPointer
                current.next = searchPointer.next;
                searchPointer.next = current;
            }
        }

        // Update the head of the sorted list
        head = sortedListHead;

        // Update the tail of the sorted list
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);
        ll
                .append(2).append(3).append(3).append(1)
                .append(3).append(4).append(5).append(6)
                .append(7).append(6).append(8).append(9)
                .append(10).prepend(0);
        ll.printList();
        ll.reverse();
        ll.printList();
        ll.reverse();
        ll.removeDuplicates();
        ll.printList();
        ll.reverseBetween(2,7);
        ll.printList();
        ll.swapPairs();
        ll.printList();
        ll.partitionList(8);
        ll.printList();

        LinkedList l1 = new LinkedList(1);
        l1.append(3);
        l1.append(5);
        l1.append(7);

        LinkedList l2 = new LinkedList(2);
        l2.append(4);
        l2.append(6);
        l2.append(8);

        l1.merge(l2);

        l1.printAll();
    }
}