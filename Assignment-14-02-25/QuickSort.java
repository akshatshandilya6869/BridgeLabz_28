
import java.util.Arrays;

public class QuickSort {
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(prices, low, high);

            // Recursively sort the left and right subarrays
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    private static int partition(double[] prices, int low, int high) {
        double pivot = prices[high]; // Choosing the last element as the pivot
        int i = low - 1; // Pointer for smaller element

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap pivot element to its correct position
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1; // Return pivot index
    }

    public static void main(String[] args) {
        double[] productPrices = {599.99, 299.50, 149.99, 799.25, 499.75, 99.99};

        System.out.println("Original Product Prices: " + Arrays.toString(productPrices));
        quickSort(productPrices, 0, productPrices.length - 1);
        System.out.println("Sorted Product Prices: " + Arrays.toString(productPrices));
    }
}

