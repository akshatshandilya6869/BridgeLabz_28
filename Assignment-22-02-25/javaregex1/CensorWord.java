package Java_Regex;

import java.util.*;

public class CensorWord {
    public static String censorWord(String st, List<String> badWords) {
        for (String word : badWords)
            st = st.replaceAll("(?i)\\b" + word + "\\b", "****");
        return st;
    }

    public static void main(String[] args) {
        System.out.println(censorWord("This is a damn bad example with some stupid words.", Arrays.asList("damn", "stupid")));
    }
}
