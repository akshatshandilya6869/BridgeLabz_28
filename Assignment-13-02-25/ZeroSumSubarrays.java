
import java.util.*;

class ZeroSumSubarrays {
    // Function to find all subarrays with zero sum
    public static List<int[]> findZeroSumSubarrays(int[] nums) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        // Initialize with sum 0 at index -1 for handling cases where subarray starts from index 0
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // Calculate cumulative sum

            // If this sum has been seen before, zero-sum subarrays exist
            if (sumMap.containsKey(sum)) {
                for (int start : sumMap.get(sum)) {
                    result.add(new int[]{start + 1, i}); // Store (start+1, end) as a valid subarray
                }
            }

            // Store the index for this cumulative sum
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result;
    }

    // Helper function to print subarrays
    private static void printSubarrays(List<int[]> subarrays, int[] nums) {
        for (int[] range : subarrays) {
            System.out.print("Subarray from index " + range[0] + " to " + range[1] + " -> ");
            for (int j = range[0]; j <= range[1]; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -7, 1, 3, 3, -4, -3, 1, 4};
        List<int[]> subarrays = findZeroSumSubarrays(nums);

        System.out.println("Zero-sum subarrays:");
        printSubarrays(subarrays, nums);
    }
}

