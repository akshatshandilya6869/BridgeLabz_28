import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import com.intellij.openapi.util.text.StringUtil;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class DateFormatter {
    public static String formatDate(String inputDate) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }
}

public class DateFormatterTest extends BasePlatformTestCase {
    @Test
    public void testValidDate() {
        assertEquals("25-12-2023", DateFormatter.formatDate("2023-12-25"));
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"));
    }

    @Test
    public void testInvalidDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("2023/12/25"));
        assertEquals("Invalid date format", exception.getMessage());
    }

    @Test
    public void testEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate(""));
        assertEquals("Invalid date format", exception.getMessage());
    }
}
