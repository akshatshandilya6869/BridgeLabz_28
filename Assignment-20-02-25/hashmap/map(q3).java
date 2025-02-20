import java.util.*;

public class MaxValueKeyFinder {
    public static void main(String[] args) {
        Map data = new HashMap();
        data.put("A", 10);
        data.put("B", 20);
        data.put("C", 15);

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Object key : data.keySet()) {
            int value = (Integer) data.get(key);
            if (value > maxValue) {
                maxValue = value;
                maxKey = (String) key;
            }
        }

        System.out.println("Key with Highest Value: " + maxKey);
    }
}
