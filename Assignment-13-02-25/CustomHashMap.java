
import java.util.LinkedList;

class CustomHashMap<K, V> {
    private static final int SIZE = 16; // Default size
    private LinkedList<Entry<K, V>>[] map;

    // Entry class representing key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize the array of linked lists
    public CustomHashMap() {
        map = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = new LinkedList<>();
        }
    }

    // Hash function to map keys to indices
    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    // Insert or Update a key-value pair
    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = map[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing key
                return;
            }
        }
        bucket.add(new Entry<>(key, value)); // Insert new entry
    }

    // Retrieve the value associated with a key
    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = map[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    // Remove a key-value pair
    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = map[index];

        bucket.removeIf(entry -> entry.key.equals(key));
    }

    // Display the contents of the hash map
    public void printMap() {
        for (int i = 0; i < SIZE; i++) {
            if (!map[i].isEmpty()) {
                System.out.print("Bucket " + i + " -> ");
                for (Entry<K, V> entry : map[i]) {
                    System.out.print("[" + entry.key + "=" + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();
        hashMap.put("Alice", 25);
        hashMap.put("Bob", 30);
        hashMap.put("Charlie", 35);
        hashMap.put("Alice", 26); // Updating Alice's value

        System.out.println("Alice's Age: " + hashMap.get("Alice"));
        System.out.println("Bob's Age: " + hashMap.get("Bob"));

        hashMap.remove("Bob");
        System.out.println("After removing Bob:");
        hashMap.printMap();
    }
}

