
import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] employeeIds) {
        int n = employeeIds.length;

        for (int i = 1; i < n; i++) {
            int key = employeeIds[i];
            int j = i - 1;

            // Shift elements of the sorted part to the right to find the correct position for key
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j--;
            }
            employeeIds[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIds = {104, 102, 109, 101, 108, 103};

        System.out.println("Original Employee IDs: " + Arrays.toString(employeeIds));
        insertionSort(employeeIds);
        System.out.println("Sorted Employee IDs: " + Arrays.toString(employeeIds));
    }
}

