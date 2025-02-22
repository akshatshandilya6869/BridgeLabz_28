import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidator {
    public static boolean isValid(String password) {
        return password.length() >= 8 &&
               password.chars().anyMatch(Character::isUpperCase) &&
               password.chars().anyMatch(Character::isDigit);
    }
}

public class PasswordValidatorTest extends BasePlatformTestCase {
    @Test
    public void testValidPassword() {
        assertTrue(PasswordValidator.isValid("StrongP@ss1"));
    }

    @Test
    public void testShortPassword() {
        assertFalse(PasswordValidator.isValid("Short1"));
    }

    @Test
    public void testNoUppercase() {
        assertFalse(PasswordValidator.isValid("weakpassword1"));
    }

    @Test
    public void testNoDigit() {
        assertFalse(PasswordValidator.isValid("NoDigitPass"));
    }
}
