 import java.util.*;

class PairWithGivenSum {
    // Function to check if a pair exists with the given sum
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            int complement = target - num;

            // If the complement exists in the set, we found a pair
            if (seen.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return true;
            }

            // Store the current number in the set
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {10, 15, 3, 7};
        int target = 17;

        if (!hasPairWithSum(nums, target)) {
            System.out.println("No pair found.");
        }
    }
}
