
       import java.util.Stack;

class QueueUsingStacks {
    private Stack<Integer> stack1; // For enqueue operation
    private Stack<Integer> stack2; // For dequeue operation

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation - O(1)
    public void enqueue(int value) {
        stack1.push(value);
    }

    // Dequeue operation - Amortized O(1), Worst-case O(n)
    public int dequeue() {
        if (stack2.isEmpty()) {
            // Transfer elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return stack2.pop();
    }

    // Peek operation - O(1) if stack2 is not empty, else O(n)
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return stack2.peek();
    }

    // Check if queue is empty - O(1)
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.peek());    // Output: 2
        System.out.println(queue.dequeue()); // Output: 2
        System.out.println(queue.isEmpty()); // Output: false
    }
}

