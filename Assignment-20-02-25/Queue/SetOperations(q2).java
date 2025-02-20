import java.util.*;

public class SetOperations {
    public static Set union(Set set1, Set set2) {
        Set result = new HashSet(set1); // Copy set1
        result.addAll(set2); // Add all elements from set2
        return result;
    }

    public static Set intersection(Set set1, Set set2) {
        Set result = new HashSet(set1); // Copy set1
        result.retainAll(set2); // Keep only common elements
        return result;
    }

    public static void main(String[] args) {
        Set set1 = new HashSet(Arrays.asList(1, 2, 3));
        Set set2 = new HashSet(Arrays.asList(3, 4, 5));

        System.out.println("Union: " + union(set1, set2));
        System.out.println("Intersection: " + intersection(set1, set2));
    }
}
