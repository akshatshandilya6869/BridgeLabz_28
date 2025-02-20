import java.util.*;

public class RotateList {
    public static <T> void rotateList(List<T> list, int positions) {
        int size = list.size();
        positions = positions % size; // Handle cases where positions > size

        List<T> rotated = new ArrayList<>(list.subList(positions, size)); // Extract from 'positions' to end
        rotated.addAll(list.subList(0, positions)); // Append the first 'positions' elements

        list.clear(); // Clear the original list
        list.addAll(rotated); // Copy rotated values back to original list
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;

        rotateList(list, rotateBy);
        System.out.println("Rotated List: " + list);
    }
}
