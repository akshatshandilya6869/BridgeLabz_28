
import java.util.Arrays;

public class HeapSort {
    public static void heapSort(double[] salaries) {
        int n = salaries.length;

        // Build Max Heap (rearrange the array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap root (max element) with last element
            double temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Reheapify the reduced heap
            heapify(salaries, i, 0);
        }
    }

    private static void heapify(double[] salaries, int n, int i) {
        int largest = i; // Assume root is the largest
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // Check if left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // Check if right child is larger than largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            double temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    public static void main(String[] args) {
        double[] salaryDemands = {55000, 75000, 50000, 90000, 60000, 65000};

        System.out.println("Original Salary Demands: " + Arrays.toString(salaryDemands));
        heapSort(salaryDemands);
        System.out.println("Sorted Salary Demands: " + Arrays.toString(salaryDemands));
    }
}

