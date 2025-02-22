package Java_Regex;

import java.util.*;
import java.util.regex.*;

public class ExtractLink {
    public static List<String> extractLink(String st) {
        List<String> list = new ArrayList<>();
        Matcher m = Pattern.compile("https?://\\S+").matcher(st);
        while (m.find()) list.add(m.group());
        return list;
    }

    public static void main(String[] args) {
        System.out.println(extractLink("Visit https://www.google.com and http://example.org for more info."));
    }
}
