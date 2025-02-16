
public class FirstNegativeSearch {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i; // Return index of first negative number
            }
        }
        return -1; // Return -1 if no negative number is found
    }

    public static void main(String[] args) {
        int[] numbers = {3, 7, 1, 5, -4, 8, -2}; // Example array

        int index = findFirstNegative(numbers);
        if (index != -1) {
            System.out.println("First negative number found at index: " + index);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }
}

