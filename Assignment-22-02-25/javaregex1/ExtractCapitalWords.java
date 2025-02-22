package Java_Regex;

import java.util.*;
import java.util.regex.*;

public class ExtractCapitalWords {
    public static List<String> extractWords(String st) {
        List<String> list = new ArrayList<>();
        Matcher m = Pattern.compile("\\b[A-Z][a-z]+\\b").matcher(st);
        while (m.find())
            list.add(m.group());
        return list;
    }

    public static void main(String[] args) {
        System.out.println(extractWords("The Eiffel Tower is in Paris and the Statue of Liberty is in New York."));
    }
}
