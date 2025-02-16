
import java.util.Arrays;

public class SearchChallenge {
    
    // Function to find the first missing positive integer using Linear Search
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number in its correct index (if possible)
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Step 2: Find the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    // Function to find the index of a target number using Binary Search
    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr); // Ensure the array is sorted
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Return the index of the found target
            } else if (arr[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};  // Example input
        int missingNumber = findFirstMissingPositive(nums);
        System.out.println("First Missing Positive Integer: " + missingNumber);

        int[] arr = {5, 1, 3, 8, 7};
        int target = 3;
        int index = binarySearch(arr, target);
        System.out.println("Index of Target (" + target + "): " + index);
    }
}

