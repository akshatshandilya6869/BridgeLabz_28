import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberUtils {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}

public class NumberUtilsTest extends BasePlatformTestCase {
    private NumberUtils numberUtils;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        numberUtils = new NumberUtils();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 7, 9})
    public void testIsEven(int number) {
        boolean expected = (number % 2 == 0);
        assertEquals(expected, numberUtils.isEven(number));
    }
}
