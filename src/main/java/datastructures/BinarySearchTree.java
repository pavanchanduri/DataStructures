package datastructures;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree {

    Node root;
    ArrayList<Integer> resultList = new ArrayList<>();

    class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * Inserts a new value into the binary search tree.
     * If the value already exists, it does not insert it again.
     * 
     * The algorithm works as follows:
     * 1. Create a new node with the given value.
     * 2. If the tree is empty, set the root to be the new node
     * 3. Otherwise, start at the root node and traverse the tree:
     *   - If the new node's value is equal to the current node's value,
     *     return false (indicating that the insertion failed due to a duplicate).
     *  - If the new node's value is less than the current node's value,
     *    - If the current node does not have a left child,
     *      set the left child of the current node to be the new node
     *     - Otherwise, set temp to be the left child of the current node and continue looping.
     *  - If the new node's value is greater than the current node's value,
     *    - If the current node does not have a right child,
     *     set the right child of the current node to be the new node
     *     - Otherwise, set temp to be the right child of the current node and continue looping.
     * 
     * @param value the value to be inserted
     */
    public void insert(int value) {
        // Create a new node with the given value
        Node newNode = new Node(value);

        // If the tree is empty...
        if (root == null) {
            // Set the root to be the new node
            root = newNode;
            // Return true to indicate that the insertion was successful
            return;
        }

        // Set temp to be the root node
        Node temp = root;

        // Loop until the new node is successfully inserted or determined to be a duplicate
        while (true) {
            // If the new node's value is equal to the current node's value, return false to indicate that the insertion failed
            if (newNode.value == temp.value)
                return;

            // If the new node's value is less than the current node's value...
            if (newNode.value < temp.value) {
                // If the current node does not have a left child...
                if (temp.left == null) {
                    // Set the left child of the current node to be the new node
                    temp.left = newNode;
                    // Return true to indicate that the insertion was successful
                    return;
                }
                // Otherwise, set temp to be the left child of the current node and continue looping
                temp = temp.left;
            } else {
                // If the current node does not have a right child...
                if (temp.right == null) {
                    // Set the right child of the current node to be the new node
                    temp.right = newNode;
                    // Return true to indicate that the insertion was successful
                    return;
                }
                // Otherwise, set temp to be the right child of the current node and continue looping
                temp = temp.right;
            }
        }
    }

    /**
     * Checks if the binary search tree contains a node with the given value.
     * 
     * The algorithm works as follows:
     * 1. If the tree is empty, return false.
     * 2. Start at the root node.
     * 3. Loop until we find a node with the given value or exhaust the search space:
     *   - If the given value is less than the current node's value, search the left subtree.
     *   - If the given value is greater than the current node's value, search the right subtree.
     *   - If the given value is equal to the current node's value, we've found the node, so return true.
     * 4. If we've exhausted the search space without finding the value, return false.
     * 
     * @param value the value to search for in the binary search tree
     * @return true if the tree contains a node with the given value, false otherwise
     */
    public boolean contains(int value) {
        // If the tree is empty, return false
        if (root == null) {
            return false;
        }

        // Start at the root node
        Node temp = root;

        // Loop until we find a node with the given value or exhaust the search space
        while (temp != null) {
            if (value < temp.value) {
                // If the given value is less than the current node's value, search the left subtree
                temp = temp.left;
            } else if (value > temp.value) {
                // If the given value is greater than the current node's value, search the right subtree
                temp = temp.right;
            } else {
                // If the given value is equal to the current node's value, we've found the node, so return true
                return true;
            }
        }

        // If we've exhausted the search space without finding the value, return false
        return false;
    }

    /**
     * Finds the minimum value in the binary search tree.
     * The minimum value is found by traversing the left subtree until a null node is encountered
     * 
     * The algorithm works as follows:
     * 1. Start at the current node.
     * 2. While the left child of the current node is not null, move to the left child.
     * 3. When a null left child is encountered, the current node is the leftmost node,
     *    which contains the minimum value in the binary search tree.
     * 4. Return the value of the current node.
     * 
     * @param currentNode the node from which to start searching for the minimum value
     * @return the minimum value in the binary search tree
     */
    public int minValue(Node currentNode) {
        // Traverse left subtree until null is encountered
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        // Return the value of the leftmost node
        return currentNode.value;
    }

    /**
     * Finds the maximum value in the binary search tree.
     * The maximum value is found by traversing the right subtree until a null node is encountered
     * 
     * The algorithm works as follows:
     * 1. Start at the current node.
     * 2. While the right child of the current node is not null, move to the right child.
     * 3. When a null right child is encountered, the current node is the rightmost node,
     *    which contains the maximum value in the binary search tree.
     * 4. Return the value of the current node.
     * 
     * @param currentNode the node from which to start searching for the maximum value
     * @return the maximum value in the binary search tree
     */
    public int maxValue(Node currentNode) {
        // Traverse right subtree until null is encountered
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        // Return the value of the rightmost node
        return currentNode.value;
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    /**
     * Recursively checks if the binary search tree contains a node with the given value.
     * 
     * The algorithm works as follows:
     * 1. If the current node is null, return false (base case).
     * 2. If the current node's value equals the search value, return true.
     * 3. If the search value is less than the current node's value, recursively search in the left subtree.
     * 4. If the search value is greater than the current node's value, recursively search in the right subtree.
     * 
     * @param currentNode the current node being checked
     * @param value the value to search for in the binary search tree
     * @return true if a node with the given value exists, false otherwise
     */
    private boolean rContains(Node currentNode, int value) {
        // If node is null, return false
        if (currentNode == null) return false;

        // If current node's value equals search value, return true
        if (currentNode.value == value) return true;

        // If search value is less than node's value,
        // search in the left subtree
        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            // If search value is more than node's value,
            // search in the right subtree
            return rContains(currentNode.right, value);
        }
    }

    public Node rInsert(int value) {
        return rInsert(root, value);
    }

    /**
     * Recursively inserts a new value into the binary search tree.
     * 
     * The algorithm works as follows:
     * 1. If the current node is null, create a new node with the value and return it.
     * 2. If the value is less than the current node's value, recursively insert it in the left subtree.
     * 3. If the value is greater than the current node's value, recursively insert it in the right subtree.
     * 4. If the value is equal to the current node's value, do nothing (no duplicates allowed).
     * 5. Return the current node after insertion.
     * 
     * @param currentNode the current node being checked
     * @param value the value to be inserted
     * @return the modified tree with the new value inserted
     */
    private Node rInsert(Node currentNode, int value) {
        // If the node is null, create a new node with the value
        if (currentNode == null) return new Node(value);

        // If the value is less than current node's value,
        // try to insert it in the left subtree
        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        }
        // If the value is greater than current node's value,
        // try to insert it in the right subtree
        else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        // Return the current node after insertion
        return currentNode;
    }

    public int deleteNode(int value) {
        Node newHead = deleteNode(root, value);
        return newHead.value;
    }

    /**
     * Deletes a node with the specified value from the binary search tree.
     * 
     * The algorithm works as follows:
     * 1. If the tree is empty, return null.
     * 2. If the value to be deleted matches the current node's value, call a helper function to handle deletion.
     * 3. If the value is less than the current node's value, recursively search in the left subtree.
     * 4. If the value is greater than the current node's value, recursively search in the right subtree.
     * 5. Return the modified tree after deletion.
     * 
     * @param root the root of the binary search tree
     * @param value the value to be deleted
     * @return the modified tree after deletion
     */
    private Node deleteNode(Node root, int value) {
        if(root==null) return null; //when the tree is empty
        if(root.value == value) {
            return helper(root);
        }
        Node currentNode = root;
        while(root!=null) {
            if(root.value>value) {
                if(root.left!=null && root.left.value == value) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if(root.right!=null && root.right.value == value) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return currentNode;
    }

    /**
     * Helper function to handle the deletion of a node with two children.
     * It finds the right child and connects it to the last right node of the left subtree.
     * 
     * The algorithm works as follows:
     * 1. If the left child is null, return the right child (if it exists).
     * 2. If the right child is null, return the left child (if it exists).
     * 3. If both children exist, find the last right node in the left subtree.
     * 4. Connect the right child to the last right node of the left subtree.
     * 5. Return the left child as the new root of the subtree.
     * 
     * @param node the node to be deleted
     * @return the new root of the subtree after deletion
     */
    private Node helper(Node node) {
        if(node.left == null) {
            return node.right;
        }
        if(node.right == null) {
            return node.left;
        }
        Node rightChild = node.right;
        Node lastRight = findLastRightNode(node.left);
        lastRight.right = rightChild;
        return node.left; //This would be the new root
    }

    private Node findLastRightNode(Node node) {
        if(node.right==null) return node;
        return findLastRightNode(node.right);
    }

    public void rDeleteNode(int value) {
        rDeleteNode(root, value);
    }

    /**
     * Recursively deletes a node with the specified value from the binary search tree.
     * 
     * The algorithm works as follows:
     * 1. If the current node is null, return null (base case).
     * 2. If the value to be deleted is less than the current node's value,
     *    recursively search in the left subtree.
     * 3. If the value to be deleted is greater than the current node's value,
     *    recursively search in the right subtree.
     * 4. If the value to be deleted matches the current node's value:
     *    - If the current node is a leaf node (no children), return null.
     *    - If the current node has only a right child, return the right child.
     *    - If the current node has only a left child, return the left child.
     *    - If the current node has two children, find the minimum value in the right subtree,
     *      replace the current node's value with that minimum value, and delete the minimum
     *      value from the right subtree.
     * 5. Return the modified current node after deletion.
     * 
     * @param currentNode
     * @param value
     * @return
     */
    private Node rDeleteNode(Node currentNode, int value) {
        // Base case, tree is empty
        if (currentNode == null) return null;

        // Recurse down the tree
        if (value < currentNode.value) {
            // If less, go left
            currentNode.left = rDeleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            // If more, go right
            currentNode.right = rDeleteNode(currentNode.right, value);
        } else {
            // Value is same as current's value, node to delete
            if (currentNode.left == null && currentNode.right == null) {
                // Node is a leaf node
                return null;
            } else if (currentNode.left == null) {
                // Node has only right child
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                // Node has only left child
                currentNode = currentNode.left;
            } else {
                // Node has two children
                int subTreeMin = minValue(currentNode.right);
                // Replace with min in right subtree
                currentNode.value = subTreeMin;
                // Delete the minimum in right subtree (which is a duplicate now)
                currentNode.right = rDeleteNode(currentNode.right, subTreeMin);
            }
        }
        // Return the modified tree
        return currentNode;
    }

    /**
     * Performs an inorder traversal of the binary search tree.
     * 
     * The algorithm works as follows:
     * 1. If the current node is null, return (base case).
     * 2. Recursively traverse the left subtree.
     * 3. Print the value of the current node.
     * 4. Recursively traverse the right subtree.
     * 
     * @param node the current node being traversed
     */
    private void inorderTraversal(Node node) {
        if(node==null) return;
        //Left -> Data -> Right
        inorderTraversal(node.left);
        System.out.print(node.value+" ");
        inorderTraversal(node.right);
    }

    /**
     * Performs a preorder traversal of the binary search tree.
     * 
     * The algorithm works as follows:
     * 1. If the current node is null, return (base case).
     * 2. Print the value of the current node.
     * 3. Recursively traverse the left subtree.
     * 4. Recursively traverse the right subtree.
     * 
     * @param node the current node being traversed
     */
    private void preOrderTraversal(Node node) {
        if(node==null) return;
        //Data -> Left -> Right
        System.out.print(node.value+" ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    /**
     * Performs a postorder traversal of the binary search tree.
     * 
     * The algorithm works as follows:
     * 1. If the current node is null, return (base case).
     * 2. Recursively traverse the left subtree.
     * 3. Recursively traverse the right subtree.
     * 4. Print the value of the current node.
     * 
     * @param node the current node being traversed
     */
    private void postOrderTraversal(Node node) {
        if(node==null) return;
        //Left -> Right -> Data
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value+" ");
    }

    /**
     * Finds the height of the binary search tree.
     * 
     * The height is defined as the number of edges on the longest path from the root to a leaf node.
     * 
     * The algorithm works as follows:
     * 1. If the current node is null, return -1 (base case).
     * 2. Recursively find the height of the left and right subtrees.
     * 3. Return the maximum height of the two subtrees plus one for the current node.
     * 
     * @param root the root of the binary search tree
     * @return the height of the binary search tree
     */
    private int findHeight(Node root) {
        if(root==null) return -1; //Assumption that the lowest node is at height 0
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }

    /**
     * Checks if the binary search tree is a valid BST.
     * A valid BST is defined as a tree where for every node:
     * - All values in the left subtree are less than the node's value.
     * - All values in the right subtree are greater than the node's value.
     * 
     * The algorithm works as follows:
     * 1. Perform an inorder traversal of the tree and store the values in a list.
     * 2. Check if the list is sorted in ascending order.
     * 
     * @return true if the tree is a valid BST, false otherwise
     */
    public boolean isValidBST() {
        ArrayList<Integer> inorderResult = DFSInOrder();
        //Inorder traversal -> Sorted List
        for(int i=0;i<inorderResult.size()-1;i++) {
            if(inorderResult.get(i)>inorderResult.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> DFSInOrder() {
        DFSInOrder(root);
        return resultList;
    }

    /**
     * Performs a depth-first search (DFS) in-order traversal of the binary search tree.
     * 
     * The algorithm works as follows:
     * 1. If the current node is null, return (base case).
     * 2. Recursively traverse the left subtree.
     * 3. Add the value of the current node to the result list.
     * 4. Recursively traverse the right subtree.
     * 
     * @param node the current node being traversed
     */
    private void DFSInOrder(Node node) {
        if(node==null) {
            return;
        }
        DFSInOrder(node.left);
        resultList.add(node.value);
        DFSInOrder(node.right);
    }

    /**
     * Converts a sorted array into a balanced binary search tree (BST).
     * 
     * The algorithm works as follows:
     * 1. Find the middle element of the array to be the root of the BST.
     * 2. Recursively create the left subtree using the left half of the array.
     * 3. Recursively create the right subtree using the right half of the array.
     * 
     * @param nums the sorted array to be converted into a BST
     * @param left the starting index of the current subarray
     * @param right the ending index of the current subarray
     * @return the root node of the constructed BST
     */
    private Node sortedArrayToBST(int[] nums, int left, int right) {
        if(left>right) return null;
        int mid = (left+right)/2;

        Node root = new Node(nums[mid]);

        // Create left subtree
        root.left = sortedArrayToBST(nums, left, mid - 1);

        // Create right subtree
        root.right = sortedArrayToBST(nums, mid + 1, right);

        return root;

    }

    public void sortedArrayToBST(int[] nums) {
        root = sortedArrayToBST(nums, 0, nums.length-1);
    }

    /**
     * Inverts the binary search tree by swapping the left and right children of each node.
     * 
     * The algorithm works as follows:
     * 1. If the current node is null, return null (base case).
     * 2. Recursively invert the right subtree and set it as the left child of the current node.
     * 3. Recursively invert the left subtree and set it as the right child of the current node.
     * 4. Return the current node after inverting its children.
     * 
     * @param node the current node being inverted
     * @return the current node after inverting its children
     */
    private Node invertTree(Node node) {
        // Check if the current node is null. This condition is crucial because it
        // serves as the termination condition for the recursion. When the method
        // encounters a null, it means it has reached beyond the leaf nodes of the
        // tree (i.e., it's at a position where a leaf node would have a child if
        // leaf nodes could have children). Since there's nothing to invert at this
        // point, the method simply returns null without making any changes.
        if (node == null) return null;

        // Temporarily store the current node's left child in a variable named 'temp'.
        // This step is necessary because the inversion process will overwrite the
        // 'left' pointer of the current node with the value of its 'right' pointer.
        // Storing the original left child allows us to access it later when we need
        // to set the current node's right child. Without this temporary storage, the
        // original left child would be lost after setting the current node's left child
        // to the inverted right subtree.
        Node temp = node.left;

        // Recursively invert the right subtree. The method calls itself with the
        // current node's right child as the argument. This recursive call will
        // continue down the right subtree, inverting each node's children along the
        // way. Once the inversion of the right subtree is complete, the method
        // sets the current node's left child to the result. This effectively moves
        // the entire right subtree to the left side of the current node. The
        // recursion ensures that every node in the right subtree is processed
        // and inverted in a bottom-up manner, starting from the rightmost leaf nodes.
        node.left = invertTree(node.right);

        // Recursively invert the original left subtree, which is now stored in 'temp'.
        // This step is similar to the previous one but operates on the original left
        // subtree of the current node. By calling 'invertTree' with 'temp' (the
        // original left child) as the argument, the method inverts the left subtree
        // and sets the result as the current node's right child. This moves the entire
        // left subtree, now inverted, to the right side of the current node. As with
        // the right subtree, the inversion is performed recursively in a bottom-up
        // fashion, ensuring that the structure of the subtree is correctly mirrored.
        node.right = invertTree(temp);

        // Return the current node. By this point in the method, the current node's
        // left and right children have been swapped, and the subtrees rooted at
        // those children have been inverted. Returning the current node allows the
        // parent call (one level up in the recursion stack) to receive the inverted
        // subtree and continue the inversion process up the tree. This step is
        // repeated until the recursion unwinds back to the root of the tree,
        // at which point the entire tree has been inverted.
        return node;
    }

    public void invertTree() {
        invertTree(root);
    }

    /**
     * Performs a breadth-first traversal of the binary search tree.
     * 
     * The algorithm works as follows:
     * 1. Initialize a queue to keep track of nodes to be visited.
     * 2. Start with the root node and add it to the queue.
     * 3. While the queue is not empty:
     *   - Remove the first node from the queue and add its value to the results list.
     *   - If the removed node has a left child, add it to the queue.
     *   - If the removed node has a right child, add it to the queue.
     * 4. Return the results list containing values in BFS order.
     * 
     * @return an ArrayList containing values of nodes visited in BFS order
     */
    public ArrayList<Integer> breadthFirstTraversal() {
        // Initialize currentNode with the root of the tree
        Node currentNode = root;

        // Create a queue to store nodes for BFS traversal
        Queue<Node> queue = new LinkedList<>();

        // Initialize an ArrayList to store visited node values
        ArrayList<Integer> results = new ArrayList<>();

        // Add the root node to the queue
        queue.add(currentNode);

        // Main loop for BFS traversal, continues until the queue is empty
        while (!queue.isEmpty()) {
            // Remove the first node from the queue and set it as currentNode
            currentNode = queue.remove();

            // Add the value of currentNode to the results ArrayList
            results.add(currentNode.value);

            // If currentNode has a left child, add it to the queue
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            // If currentNode has a right child, add it to the queue
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        // Return the results ArrayList containing the values of visited nodes in BFS order
        return results;
    }

    /**
     * Performs a zigzag traversal of the binary search tree.
     * 
     * The algorithm works as follows:
     * 1. Use two stacks to keep track of nodes at the current and next levels.
     * 2. Start with the root node in the first stack.
     * 3. Alternate between popping nodes from the first stack and pushing their children onto the second stack,
     *    while adding values to the results list in zigzag order.
     * 4. Continue until both stacks are empty.
     * 
     * @param root the root of the binary search tree
     * @return an ArrayList containing values of nodes visited in zigzag order
     */
    static ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        // Current level
        Stack<Node> s1 = new Stack<>();

        // Next level
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while (!s1.empty() || !s2.empty()) {

            // Print nodes of current level from s1
            // and push nodes of next level to s2
            while (!s1.empty()) {
                Node curr = s1.pop();
                res.add(curr.value);

                if (curr.left != null)
                    s2.push(curr.left);
                if (curr.right != null)
                    s2.push(curr.right);
            }

            // Print nodes of current level from s2
            // and push nodes of next level to s1
            while (!s2.empty()) {
                Node curr = s2.pop();
                res.add(curr.value);

                if (curr.right != null)
                    s1.push(curr.right);
                if (curr.left != null)
                    s1.push(curr.left);
            }
        }
        return res;
    }

    /**
     * Finds the k-th smallest element in the binary search tree.
     * 
     * The algorithm works as follows:
     * 1. Use an iterative approach with a stack to perform an in-order traversal.
     * 2. Traverse to the leftmost node, pushing all nodes onto the stack.
     * 3. Pop nodes from the stack and decrement k for each node processed.
     * 4. When k reaches 0, return the value of the current node.
     * 
     * @param k the index of the smallest element to find (1-based index)
     * @return the value of the k-th smallest element, or null if fewer than k nodes exist
     */
    public Integer kthSmallest(int k) {
        // Create an empty stack to keep track of nodes
        Stack<Node> stack = new Stack<>();

        // Start from the root of the BST
        Node node = this.root;

        // Continue as long as there are unprocessed nodes
        while (!stack.isEmpty() || node != null) {

            // Traverse to the leftmost node of the current subtree,
            // pushing all the nodes onto the stack
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            // Process nodes from the stack when no left children
            node = stack.pop();

            // Decrement k after each processed node
            k -= 1;

            // If k reaches 0, return the current node value
            if (k == 0) {
                return node.value;
            }

            // Move to the right child after a node has been processed
            node = node.right;
        }

        // Return null if fewer than k nodes in the tree
        return null;
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(52);
        bst.insert(82);
        bst.insert(42);
        bst.insert(27);
        bst.rInsert(17);
        System.out.println(bst.breadthFirstTraversal().stream().toList());
        System.out.println("Inorder Traversal of the Tree: ");
        bst.inorderTraversal(bst.root);
        System.out.println("\nPreorder Traversal of the Tree: ");
        bst.preOrderTraversal(bst.root);
        System.out.println("\nPostorder Traversal of the Tree: ");
        bst.postOrderTraversal(bst.root);
        System.out.println();
        System.out.println("Height of the tree: "+bst.findHeight(bst.root));
        System.out.println(bst.contains(27));
        System.out.println(bst.rContains(42));
        System.out.println(bst.root.value);
        System.out.println(bst.minValue(bst.root));
        System.out.println(bst.maxValue(bst.root));
        System.out.println(bst.deleteNode(47));
        bst.rDeleteNode(17);
        System.out.println(bst.contains(17));
        bst.invertTree();
        System.out.println(bst.root.left.value);

        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        bst.sortedArrayToBST(arr);
        System.out.println(bst.root.value);
        System.out.println(bst.isValidBST());
        System.out.println(bst.breadthFirstTraversal());
        System.out.println(BinarySearchTree.zigZagTraversal(bst.root));
    }
}
