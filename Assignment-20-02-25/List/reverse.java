import java.util.*;

public class ReverseList {
    // Method to reverse an ArrayList
    public static <T> void reverseArrayList(List<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            // Swap elements
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    // Method to reverse a LinkedList
    public static <T> LinkedList<T> reverseLinkedList(LinkedList<T> list) {
        LinkedList<T> reversedList = new LinkedList<>();
        for (T item : list) {
            reversedList.addFirst(item); // Add elements at the beginning
        }
        return reversedList;
    }

    public static void main(String[] args) {
        // Example with ArrayList
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        reverseArrayList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        // Example with LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> reversedLinkedList = reverseLinkedList(linkedList);
        System.out.println("Reversed LinkedList: " + reversedLinkedList);
    }
}
