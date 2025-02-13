
import java.util.Stack;

class SortStackRecursively {
    
    // Recursive function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Pop the top element
            int top = stack.pop();
            
            // Recursively sort the remaining stack
            sortStack(stack);
            
            // Insert the popped element back in the correct position
            insertSorted(stack, top);
        }
    }

    // Helper function to insert an element in a sorted stack
    private static void insertSorted(Stack<Integer> stack, int element) {
        // If stack is empty or element is greater than top, push it
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            // Pop the top element and insert the element recursively
            int top = stack.pop();
            insertSorted(stack, element);
            
            // Push back the popped element
            stack.push(top);
        }
    }

    // Utility function to print the stack
    private static void printStack(Stack<Integer> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);

        System.out.println("Original Stack:");
        printStack(stack);

        sortStack(stack);

        System.out.println("Sorted Stack:");
        printStack(stack);
    }
}

