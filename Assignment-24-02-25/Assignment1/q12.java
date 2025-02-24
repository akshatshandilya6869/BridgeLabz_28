import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class ExpensiveComputation {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeFactorial(int n) {
        if (cache.containsKey(n)) {
            System.out.println("Returning cached result for: " + n);
            return cache.get(n);
        }

        System.out.println("Computing factorial for: " + n);
        int result = (n == 0) ? 1 : n * computeFactorial(n - 1);
        cache.put(n, result);
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        ExpensiveComputation computation = new ExpensiveComputation();
        
        System.out.println("Result: " + computation.computeFactorial(5)); // Computes and stores in cache
        System.out.println("Result: " + computation.computeFactorial(5)); // Returns cached result
        System.out.println("Result: " + computation.computeFactorial(6)); // Computes and stores in cache
    }
}
