import java.util.*;

public class BinaryNumberGenerator {
    public static List generateBinaryNumbers(int N) {
        List result = new ArrayList();
        Queue queue = new LinkedList();
        
        queue.add("1"); // Start with "1"
        
        for (int i = 0; i < N; i++) {
            String binary = (String) queue.remove(); // Dequeue front element
            result.add(binary); // Add to result list

            // Generate next binary numbers
            queue.add(binary + "0");
            queue.add(binary + "1");
        }
        
        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        List binaryNumbers = generateBinaryNumbers(N);
        System.out.println("First " + N + " Binary Numbers: " + binaryNumbers);
    }
}
