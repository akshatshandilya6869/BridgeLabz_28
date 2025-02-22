import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Pattern;

class UserRegistration {
    public void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (email == null || !Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
    }
}

public class UserRegistrationTest extends BasePlatformTestCase {
    private UserRegistration userRegistration;

    @BeforeEach
    public void setUp() {
        userRegistration = new UserRegistration();
    }

    @Test
    public void testValidRegistration() {
        assertDoesNotThrow(() -> userRegistration.registerUser("testUser", "test@example.com", "SecurePass1"));
    }

    @Test
    public void testEmptyUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("", "test@example.com", "SecurePass1"));
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    public void testInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("testUser", "invalid-email", "SecurePass1"));
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    public void testShortPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("testUser", "test@example.com", "short"));
        assertEquals("Password must be at least 8 characters long", exception.getMessage());
    }
}
