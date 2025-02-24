class MathOperations {
    public void fastMethod() {
        System.out.println("Fast method executing...");
    }

    public void slowMethod() {
        try {
            Thread.sleep(1000); // Simulate slow execution
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Slow method executing...");
    }
}
import java.lang.reflect.Method;

class MethodExecutionTimer {
    public static void measureExecutionTime(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            
            long startTime = System.nanoTime();
            method.invoke(obj);
            long endTime = System.nanoTime();
            
            long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
            System.out.println("Execution time of " + methodName + ": " + duration + " ms");
        } catch (Exception e) {
            System.out.println("Error executing method: " + methodName);
            e.printStackTrace();
        }
    }
}
public class ReflectionDemo {
    public static void main(String[] args) {
        MathOperations obj = new MathOperations();

        MethodExecutionTimer.measureExecutionTime(obj, "fastMethod");
        MethodExecutionTimer.measureExecutionTime(obj, "slowMethod");
    }
}
