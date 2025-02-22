package Java_Regex;

import java.util.*;
import java.util.regex.*;

public class ExtractDate {
    public static List<String> extractDates(String st) {
        List<String> list = new ArrayList<>();
        Matcher m = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b").matcher(st);
        while (m.find()) list.add(m.group());
        return list;
    }

    public static void main(String[] args) {
        System.out.println(extractDates("The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020."));
    }
}
