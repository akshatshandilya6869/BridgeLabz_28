
import java.io.*;

public class FileReadingEfficiency {
    public static void main(String[] args) {
        String filePath = "largeFile.txt";

        // Ensure a large file exists (500MB)
        createLargeFile(filePath, 500 * 1024 * 1024); // 500MB

        // Compare performance of FileReader vs. InputStreamReader
        System.out.println("Reading a 500MB file...");
        measureTime("FileReader", () -> readWithFileReader(filePath));
        measureTime("InputStreamReader", () -> readWithInputStreamReader(filePath));
    }

    // Utility method to measure execution time
    private static void measureTime(String method, Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds
        System.out.println(method + " took " + elapsedTime + " ms");
    }

    // 1. Read a file using FileReader (Character Stream - Slower for large files)
    private static void readWithFileReader(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            while (reader.read() != -1) {
                // Read character by character
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2. Read a file using InputStreamReader (Byte Stream - Faster for large files)
    private static void readWithInputStreamReader(String filePath) {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            while (reader.read() != -1) {
                // Read byte-by-byte and convert to character
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to create a large file (for testing purposes)
    private static void createLargeFile(String filePath, int sizeInBytes) {
        File file = new File(filePath);
        if (file.exists() && file.length() >= sizeInBytes) {
            System.out.println("File already exists: " + filePath);
            return; // Skip if file already exists
        }
        System.out.println("Creating large file: " + filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            char[] buffer = new char[1024]; // 1KB buffer
            for (int i = 0; i < sizeInBytes / buffer.length; i++) {
                writer.write(buffer);
            }
            System.out.println("File created: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

