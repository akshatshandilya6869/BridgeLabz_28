import com.intellij.testFramework.fixtures.BasePlatformTestCase;

class StringUtils {
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    public boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }
    
    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}

public class StringUtilsTest extends BasePlatformTestCase {
    private StringUtils stringUtils;
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        stringUtils = new StringUtils();
    }
    
    public void testReverse() {
        assertEquals("cba", stringUtils.reverse("abc"));
    }
    
    public void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertFalse(stringUtils.isPalindrome("hello"));
    }
    
    public void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
    }
}
