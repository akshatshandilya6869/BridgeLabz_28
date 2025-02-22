import com.intellij.testFramework.fixtures.BasePlatformTestCase;

class Calculator {
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
    
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
    }
    
    public void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
