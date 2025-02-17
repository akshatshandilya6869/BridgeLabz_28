
import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        
        for (int size : sizes) {
            int[] array = generateRandomArray(size);

            System.out.println("\nDataset Size: " + size);
            
            measureSortingTime("Bubble Sort", array.clone(), SortingComparison::bubbleSort);
            measureSortingTime("Merge Sort", array.clone(), SortingComparison::mergeSort);
            measureSortingTime("Quick Sort", array.clone(), SortingComparison::quickSort);
        }
    }

    // Generate a random array
    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(1000000);  // Random numbers up to 1,000,000
        }
        return array;
    }

    // Measure execution time
    private static void measureSortingTime(String algoName, int[] array, Runnable sortMethod) {
        long startTime = System.nanoTime();
        sortMethod.run();
        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1_000_000.0; // Convert to ms
        System.out.println(algoName + " took " + elapsedTime + " ms");
    }

    // Bubble Sort (O(N²))
    private static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort (O(N log N))
    private static void mergeSort(int[] array) {
        if (array.length < 2) return;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            array[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length) array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }

    // Quick Sort (O(N log N))
    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

