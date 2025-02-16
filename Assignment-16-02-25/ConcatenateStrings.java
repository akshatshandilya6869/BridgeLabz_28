
public class ConcatenateStrings {
    public static String concatenate(String[] words) {
        StringBuffer sb = new StringBuffer();

        for (String word : words) {
            sb.append(word);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Hello", " ", "World", "!", " Welcome", " to", " Java"};
        String result = concatenate(words);
        System.out.println("Concatenated String: " + result);
    }
}

