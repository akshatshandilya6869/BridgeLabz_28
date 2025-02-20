import java.util.*;

public class SubsetCheck {
    public static boolean isSubset(Set set1, Set set2) {
        return set2.containsAll(set1); // Check if set2 contains all elements of set1
    }

    public static void main(String[] args) {
        Set set1 = new HashSet();
        set1.add(2);
        set1.add(3);

        Set set2 = new HashSet();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        System.out.println("Is Set1 a subset of Set2? " + isSubset(set1, set2));
    }
}
