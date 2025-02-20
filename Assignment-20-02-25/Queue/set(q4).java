import java.util.*;

public class SetToSortedList {
    public static List convertSetToSortedList(Set set) {
        List list = new ArrayList(set); // Convert Set to List
        Collections.sort(list); // Sort the list in ascending order
        return list;
    }

    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);

        List sortedList = convertSetToSortedList(set);
        System.out.println("Sorted List: " + sortedList);
    }
}
