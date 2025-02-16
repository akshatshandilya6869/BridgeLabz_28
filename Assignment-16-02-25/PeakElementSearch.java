
public class PeakElementSearch {
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the next element, peak is on the left side
            if (arr[mid] > arr[mid + 1]) {
                right = mid; // Search in the left half (including mid)
            } else { // Otherwise, peak is on the right side
                left = mid + 1; // Search in the right half
            }
        }
        return left; // Left will point to a peak element
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0}; // Example array

        int peakIndex = findPeakElement(arr);
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element: " + arr[peakIndex]);
    }
}

