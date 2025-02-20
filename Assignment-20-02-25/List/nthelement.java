import java.util.*;

public class NthFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();
        
        // Move the 'fast' pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) return null; // If N is greater than the list size
            fast.next();
        }

        // Move both pointers until 'fast' reaches the end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next(); // The 'slow' pointer now points to the Nth element from the end
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int N = 2;

        String result = findNthFromEnd(list, N);
        System.out.println("Nth element from end: " + result);
    }
}
