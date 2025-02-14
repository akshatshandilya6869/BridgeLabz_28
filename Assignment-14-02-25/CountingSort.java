
import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1; // Range of ages (10 to 18)
        int[] count = new int[range];    // Frequency array
        int[] output = new int[ages.length]; // Sorted output array

        // Step 1: Count the occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Compute cumulative frequency
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place elements in the correct position in output array
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Step 4: Copy sorted elements back to the original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 15, 10, 18, 14, 17, 13, 11, 16, 10, 12, 15};

        System.out.println("Original Student Ages: " + Arrays.toString(studentAges));
        countingSort(studentAges, 10, 18);
        System.out.println("Sorted Student Ages: " + Arrays.toString(studentAges));
    }
}

