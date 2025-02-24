import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();

            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
            multiplyMethod.setAccessible(true); // Allow access to private method

            int result = (int) multiplyMethod.invoke(calculator, 5, 3); // Invoke method with arguments
            System.out.println("Multiplication Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
