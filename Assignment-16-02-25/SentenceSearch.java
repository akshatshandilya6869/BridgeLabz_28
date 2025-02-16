
public class SentenceSearch {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence; // Return the first sentence containing the word
            }
        }
        return "Not Found"; // Return "Not Found" if the word is not present in any sentence
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Java is a popular programming language.",
            "Linear search is simple but not always efficient.",
            "Artificial Intelligence is the future of technology."
        };

        String wordToSearch = "Java"; // Word to search for

        String result = findSentenceWithWord(sentences, wordToSearch);
        System.out.println("Result: " + result);
    }
}

