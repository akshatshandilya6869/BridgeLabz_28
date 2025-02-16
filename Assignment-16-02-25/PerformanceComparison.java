import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) {
        int iterations = 1_000_000; // 1 million iterations
        String text = "hello";

        // Measure time for StringBuffer
        long startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;
        System.out.println("Time taken by StringBuffer: " + stringBufferTime / 1_000_000 + " ms");

        // Measure time for StringBuilder
        startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime / 1_000_000 + " ms");

        System.out.println("StringBuilder is " + (double) stringBufferTime / stringBuilderTime + " times faster than StringBuffer.");

        String filePath = "large_file.txt"; // Ensure this file exists and is ~100MB

        // Measure time for FileReader
        startTime = System.nanoTime();
        int wordCountFileReader = countWordsUsingFileReader(filePath);
        endTime = System.nanoTime();
        long fileReaderTime = endTime - startTime;
        System.out.println("FileReader - Word Count: " + wordCountFileReader + " | Time taken: " + fileReaderTime / 1_000_000 + " ms");

        // Measure time for InputStreamReader
        startTime = System.nanoTime();
        int wordCountInputStreamReader = countWordsUsingInputStreamReader(filePath);
        endTime = System.nanoTime();
        long inputStreamReaderTime = endTime - startTime;
        System.out.println("InputStreamReader - Word Count: " + wordCountInputStreamReader + " | Time taken: " + inputStreamReaderTime / 1_000_000 + " ms");

        System.out.println("InputStreamReader is " + (double) fileReaderTime / inputStreamReaderTime + " times faster than FileReader.");
    }

    private static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Splitting by whitespace to count words
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return wordCount;
    }

    private static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Splitting by whitespace to count words
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return wordCount;
    }
}

