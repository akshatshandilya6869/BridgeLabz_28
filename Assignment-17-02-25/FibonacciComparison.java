
public class FibonacciComparison {
    public static void main(String[] args) {
        int[] testCases = {10, 30, 50}; // Different values of N

        for (int n : testCases) {
            System.out.println("\nFibonacci Number (N): " + n);

            measureTime("Recursive", () -> System.out.println("Result: " + fibonacciRecursive(n)));
            measureTime("Iterative", () -> System.out.println("Result: " + fibonacciIterative(n)));
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

    // 1. Recursive Fibonacci (O(2ⁿ) - Inefficient for large N)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // 2. Iterative Fibonacci (O(N) - Fast and memory-efficient)
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;

        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}

