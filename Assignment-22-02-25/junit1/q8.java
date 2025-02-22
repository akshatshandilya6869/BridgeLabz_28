import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class FileProcessor {
    public void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    public String readFromFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString().trim();
    }
}

public class FileProcessorTest extends BasePlatformTestCase {
    private FileProcessor fileProcessor;
    private final String testFilename = "testfile.txt";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        fileProcessor = new FileProcessor();
    }

    @Override
    protected void tearDown() throws Exception {
        File file = new File(testFilename);
        if (file.exists()) {
            file.delete();
        }
        super.tearDown();
    }

    @Test
    public void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, IntelliJ!";
        fileProcessor.writeToFile(testFilename, content);
        String readContent = fileProcessor.readFromFile(testFilename);
        assertEquals(content, readContent);
    }

    @Test
    public void testFileExistsAfterWriting() throws IOException {
        fileProcessor.writeToFile(testFilename, "Test Content");
        assertTrue(new File(testFilename).exists());
    }

    @Test
    public void testReadFromNonExistentFile() {
        assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistent.txt"));
    }
}
