import java.util.*;

public class ReverseQueue {
    public static Queue reverseQueue(Queue queue) {
        Stack stack = new Stack(); // Use stack to reverse order

        while (!queue.isEmpty()) {
            stack.push(queue.remove()); // Remove from queue, push to stack
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop()); // Pop from stack, add back to queue
        }

        return queue;
    }

    public static void main(String[] args) {
        Queue queue = new LinkedList();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);
        queue = reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}
