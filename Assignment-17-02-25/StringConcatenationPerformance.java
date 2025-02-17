
public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; // Different operation counts

        for (int size : sizes) {
            System.out.println("\nOperations Count (N): " + size);

            measureTime("String", () -> concatenateWithString(size));
            measureTime("StringBuilder", () -> concatenateWithStringBuilder(size));
            measureTime("StringBuffer", () -> concatenateWithStringBuffer(size));
        }
    }

    // Utility method to measure execution time
    private static void measureTime(String method, Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds
        System.out.println(method + " took " + elapsedTime + " ms");
    }

    // 1. Concatenation using String (Inefficient - O(N²))
    private static void concatenateWithString(int size) {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += "a"; // New object created on each concatenation
        }
    }

    // 2. Concatenation using StringBuilder (Efficient - O(N))
    private static void concatenateWithStringBuilder(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("a"); // Mutates the same object
        }
    }

    // 3. Concatenation using StringBuffer (Thread-safe - O(N))
    private static void concatenateWithStringBuffer(int size) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append("a"); // Synchronized, slower but safe in multithreaded environments
        }
    }
}

