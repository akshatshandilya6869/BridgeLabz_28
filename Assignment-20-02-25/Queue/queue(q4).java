import java.util.*;

public class StackUsingQueues {
    Queue queue1 = new LinkedList();
    Queue queue2 = new LinkedList();

    // Push operation
    public void push(Object data) {
        queue1.add(data); // Always add to queue1
    }

    // Pop operation
    public Object pop() {
        if (queue1.isEmpty()) {
            return null; // Stack is empty
        }

        // Move all elements except last to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // Last element in queue1 is the top of stack
        Object topElement = queue1.remove();

        // Swap queues
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Top operation (peek)
    public Object top() {
        if (queue1.isEmpty()) {
            return null;
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // Get last element (top of stack)
        Object topElement = queue1.peek();
        queue2.add(queue1.remove());

        // Swap queues
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top Element: " + stack.top()); // Output: 3
        System.out.println("Popped: " + stack.pop()); // Output: 3
        System.out.println("Popped: " + stack.pop()); // Output: 2
    }
}
