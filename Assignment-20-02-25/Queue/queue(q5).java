import java.util.*;

public class CircularBuffer {
    private int[] buffer;
    private int front, rear, size, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void insert(int data) {
        rear = (rear + 1) % capacity; // Move rear in circular fashion
        buffer[rear] = data;

        if (size < capacity) {
            size++;
        } else {
            front = (front + 1) % capacity; // Overwrite oldest element
        }
    }

    public List getBuffer() {
        List result = new ArrayList();
        for (int i = 0; i < size; i++) {
            result.add(buffer[(front + i) % capacity]);
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        System.out.println("Buffer: " + cb.getBuffer()); // Output: [1, 2, 3]

        cb.insert(4); // Overwrites oldest (1)
        System.out.println("Buffer: " + cb.getBuffer()); // Output: [2, 3, 4]
    }
}
