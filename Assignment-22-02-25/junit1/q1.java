import com.intellij.testFramework.fixtures.BasePlatformTestCase;

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

public class CalculatorTest extends BasePlatformTestCase {
    private Calculator calculator;
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        calculator = new Calculator();
    }
    
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }
    
    public void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
    }
    
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
    }
    
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
    }
    
    public void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
