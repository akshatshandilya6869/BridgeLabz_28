package Java_Regex;

import java.util.*;
import java.util.regex.*;

public class ExtractProgrammingLang {
    public static List<String> extractLang(String st) {
        List<String> list = new ArrayList<>();
        Matcher m = Pattern.compile("\\b(JavaScript|Java|Python|Go|C|C\\+\\+|Ruby|Swift|PHP)\\b").matcher(st);
        while (m.find()) list.add(m.group());
        return list;
    }

    public static void main(String[] args) {
        System.out.println(extractLang("I love Java, Python, and JavaScript, but I haven't tried Go yet."));
    }
}
