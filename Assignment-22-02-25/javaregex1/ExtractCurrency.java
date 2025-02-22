package Java_Regex;

import java.util.*;
import java.util.regex.*;

public class ExtractCurrency {
    public static List<String> extractCurrencyValues(String st) {
        List<String> list = new ArrayList<>();
        Matcher m = Pattern.compile("\\$?\\d+\\.\\d{2}").matcher(st);
        while (m.find())
            list.add(m.group());
        return list;
    }

    public static void main(String[] args) {
        System.out.println(extractCurrencyValues("The price is $45.99, and the discount is 10.50."));
    }
}
