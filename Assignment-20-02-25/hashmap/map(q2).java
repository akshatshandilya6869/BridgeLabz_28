import java.util.*;

public class InvertMap {
    public static void main(String[] args) {
        Map originalMap = new HashMap();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        Map invertedMap = new HashMap();

        for (Object key : originalMap.keySet()) {
            Object value = originalMap.get(key);

            if (!invertedMap.containsKey(value)) {
                invertedMap.put(value, new ArrayList());
            }
            ((List) invertedMap.get(value)).add(key);
        }

        System.out.println("Inverted Map: " + invertedMap);
    }
}
