import java.util.*;

public class SearchComparison {

    // Linear Search: O(N)
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Target found
            }
        }
        return -1; // Target not found
    }

    // Binary Search: O(log N)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random rand = new Random();

        for (int size : sizes) {
            int[] data = new int[size];

            // Populate dataset with random numbers
            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(size * 10);
            }

            int target = data[rand.nextInt(size)]; // Random target to search

            // Measure Linear Search time
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long endTime = System.nanoTime();
            System.out.println("Linear Search (Size: " + size + ") took " + (endTime - startTime) / 1_000_000.0 + " ms");

            // Sort for Binary Search
            Arrays.sort(data); // O(N log N)

            // Measure Binary Search time
            startTime = System.nanoTime();
            binarySearch(data, target);
            endTime = System.nanoTime();
            System.out.println("Binary Search (Size: " + size + ") took " + (endTime - startTime) / 1_000_000.0 + " ms");

            System.out.println("---");
        }
    }
}



