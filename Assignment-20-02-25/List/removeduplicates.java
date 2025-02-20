import java.util.*;

public class RemoveDuplicates {
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>(); // Stores unique elements
        List<T> result = new ArrayList<>(); // Stores final ordered elements
        
        for (T item : list) {
            if (seen.add(item)) { // Adds only if not present
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> uniqueList = removeDuplicates(list);
        System.out.println("List without duplicates: " + uniqueList);
    }
}
