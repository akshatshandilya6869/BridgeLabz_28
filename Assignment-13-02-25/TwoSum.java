
import java.util.*;

class TwoSum {
    // Function to find two indices whose sum equals the target
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>(); // Stores value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i}; // Return indices
            }

            // Store the current number and its index
            numMap.put(nums[i], i);
        }

        return new int[]{}; // Return empty array if no pair is found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        if (result.length == 2) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No pair found.");
        }
    }
}

