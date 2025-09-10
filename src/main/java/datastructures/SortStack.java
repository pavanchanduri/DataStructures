package datastructures;
import java.util.Stack;

public class SortStack {

    /**
     * Sorts a stack such that the smallest items are on the top.
     * You can use an additional temporary stack, but you may not copy the elements into any
     * other data structure (such as an array). The stack supports the following operations: push,
     * pop, peek, and isEmpty.
     * 
     * The algorithm works as follows:
     * 1. Create a temporary stack to hold the sorted elements.
     * 2. While the input stack is not empty, pop an element from the input stack.
     * 3. While the temporary stack is not empty and the top element of the temporary stack is greater than the popped element,
     *    pop elements from the temporary stack and push back into the input stack.
     * 4. Push the popped element onto the temporary stack.
     *
     * Time Complexity: O(n^2) in the worst case, where n is the number of elements in the stack.
     * Space Complexity: O(n) for the temporary stack used for sorting.
     * @param input
     * @return
     */
    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new Stack<>();
        while (!input.isEmpty()) {
            // pop out the first element
            int tmp = input.pop();

            // while temporary stack is not empty and
            // top of stack is lesser than temp
            while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
                // pop from temporary stack and
                // push it to the input stack
                input.push(tmpStack.pop());
            }

            // push temp in temporary of stack
            tmpStack.push(tmp);
        }
        return tmpStack;
    }

    public static void main(String[] args) {
        Stack<Integer> input = new Stack<>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);

        // This is the temporary stack
        Stack<Integer> tmpStack=sortStack(input);
        while (!tmpStack.empty())
        {
            System.out.println(tmpStack.pop()+" ");
        }
    }
}
