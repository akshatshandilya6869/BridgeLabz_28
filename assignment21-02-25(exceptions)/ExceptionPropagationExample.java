
public class ExceptionPropagationExample {
    
    public static void method1() throws ArithmeticException {
        System.out.println("Inside method1: About to divide by zero...");
        int result = 10 / 0; // This will cause an ArithmeticException
    }
    
    public static void method2() throws ArithmeticException {
        System.out.println("Inside method2: Calling method1...");
        method1(); // Calls method1(), exception propagates
    }
    
    public static void main(String[] args) {
        try {
            System.out.println("Inside main: Calling method2...");
            method2(); // Calls method2(), exception propagates to main
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}

