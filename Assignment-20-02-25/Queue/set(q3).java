import java.util.*;

public class SymmetricDifference {
    public static Set symmetricDifference(Set set1, Set set2) {
        Set result = new HashSet(set1); // Copy set1
        Set common = new HashSet(set1); // Copy set1 to find intersection

        result.addAll(set2); // Union of set1 and set2
        common.retainAll(set2); // Intersection of set1 and set2
        result.removeAll(common); // Remove common elements (intersection)

        return result;
    }

    public static void main(String[] args) {
        Set set1 = new HashSet(Arrays.asList(1, 2, 3));
        Set set2 = new HashSet(Arrays.asList(3, 4, 5));

        System.out.println("Symmetric Difference: " + symmetricDifference(set1, set2));
    }
}
