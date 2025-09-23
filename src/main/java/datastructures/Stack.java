package datastructures;

public class Stack<T> {

    /*
    1. Use Linked List
    2. Push -> add node at the beginning of the list
    3. Pop -> remove node from the beginning of the list
    4. This way LIFO is achieved
    5. Peek -> return the first node
    6. This way all operations are O(1)
     */
    private Node<T> top;
    private int height;
    
    public Stack() {}
    
    public Stack(T value) {
        top = new Node<>(value);
        height = 1;
    }
    
    static class Node<T> {
        T value;
        Node<T> next;
    
        public Node(T value) {
            this.value = value;
        }
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        if (top != null) {
            newNode.next = top;
        }
        top = newNode;
        height++;
    }

    public boolean search(T value) throws Exception {
        if(top == null) {
            throw new Exception("Stack is Empty");
        } else {
            Node<T> temp = top;
            while(temp!=null) {
                if(temp.value.equals(value)) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public T getTop() {
        return top.value;
    }

    public int getHeight() {
        return height;
    }

    public Node<T> pop() throws Exception {
        Node<T> temp;
        Node<T> result;
        if(top==null) {
            throw new Exception("Stack is Empty");
        } else if(height==1) {
            result = top;
            top = null;
            height = 0;
        } else {
            result = top;
            temp = top.next;
            top.next = null;
            top = temp;
            height--;
        }
        return result;
    }

    public T peek() throws Exception {
    
        if(height==0) {
            throw new Exception("Stack is Empty");
        } else {
            return top.value;
        }
    }

    public boolean isEmpty() {
        return height==0;
    }

    public void printStack() {
        if(top==null) {
            System.out.println("Stack is Empty");
        } else {
            Node<T> temp = top;
            System.out.print("top -> ");
            while(temp.next!=null) {
                System.out.print(temp.value+" -> ");
                temp=temp.next;
            }
            System.out.print(temp.value);
            System.out.println();
        }
    }

    /**
     * Check if the parentheses are balanced
     * The algorithm works by using a stack to keep track of opening parentheses.
     * When an opening parenthesis is encountered, it is pushed onto the stack.
     * When a closing parenthesis is encountered, the algorithm checks if the stack is empty.
     * If the stack is empty, it means there is no matching opening parenthesis, and
     * the parentheses are not balanced. If the stack is not empty, the top element is
     * popped from the stack, and the algorithm checks if it matches the closing parenthesis.
     * If it matches, the algorithm continues to the next character. If it does not match,
     * the parentheses are not balanced. At the end of the algorithm, if the stack is empty,
     * it means all opening parentheses had matching closing parentheses, and the parentheses
     * are balanced. If the stack is not empty, it means there are unmatched opening parentheses,
     * and the parentheses are not balanced.
     * 
     * @param input
     * @return
     * @throws Exception
     */
    public static boolean isBalancedParentheses(String input) throws Exception {
        Stack<Character> stack = new Stack<>();
        for(char ch:input.toCharArray()) {
            if(ch=='('||ch=='{'||ch=='[') {
                stack.push(ch);
            } else if(ch==')'||ch=='}'||ch==']') {
                if(stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                if((top=='(' && ch==')') ||
                   (top=='[' && ch==']') ||
                   (top=='{' && ch=='}')) {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.push(4);
        boolean isEmpty = stack.isEmpty();
        System.out.println(isEmpty);
        stack.printStack();
        System.out.println(stack.peek());
        System.out.println(stack.search(4));

        String parantheses = "()[]{}[";
        System.out.println(isBalancedParentheses(parantheses));
    }
}
