import java.util.*;

public class MergeMaps {
    public static void main(String[] args) {
        Map map1 = new HashMap();
        map1.put("A", 1);
        map1.put("B", 2);

        Map map2 = new HashMap();
        map2.put("B", 3);
        map2.put("C", 4);

        Map mergedMap = new HashMap(map1);

        for (Object key : map2.keySet()) {
            int value = (Integer) map2.get(key);
            if (mergedMap.containsKey(key)) {
                mergedMap.put(key, (Integer) mergedMap.get(key) + value);
            } else {
                mergedMap.put(key, value);
            }
        }

        System.out.println("Merged Map: " + mergedMap);
    }
}
