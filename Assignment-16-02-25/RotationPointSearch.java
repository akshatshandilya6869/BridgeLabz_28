
public class RotationPointSearch {
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // Avoids integer overflow

            // If mid element is greater than the rightmost element, search right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else { // Otherwise, search left half
                right = mid;
            }
        }
        return left; // Left will point to the smallest element
    }

    public static void main(String[] args) {
        int[] rotatedArray = {15, 18, 2, 3, 6, 12}; // Rotated sorted array

        int rotationIndex = findRotationPoint(rotatedArray);
        System.out.println("Rotation point index: " + rotationIndex);
        System.out.println("Smallest element: " + rotatedArray[rotationIndex]);
    }
}

