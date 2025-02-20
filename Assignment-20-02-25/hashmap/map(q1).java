import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String text = "Hello world, hello Java!"; // Example input (Replace with file reading)
        Map wordCount = new HashMap();

        // Convert text to lowercase and remove punctuation
        text = text.toLowerCase().replaceAll("[^a-z ]", ""); 
        String[] words = text.split("\\s+"); // Split words by spaces

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!word.isEmpty()) {
                if (wordCount.containsKey(word)) {
                    wordCount.put(word, (Integer) wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }
        }

        System.out.println("Word Frequency: " + wordCount);
    }
}
