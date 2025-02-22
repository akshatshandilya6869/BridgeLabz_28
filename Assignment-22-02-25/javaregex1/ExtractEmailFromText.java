package Java_Regex;

import java.util.*;
import java.util.regex.*;

public class ExtractEmailFromText {
    public static List<String> extractEmail(String text) {
        List<String> list = new ArrayList<>();
        Matcher m = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}").matcher(text);
        while (m.find()) list.add(m.group());
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Text:");
        String st = sc.nextLine();
        System.out.println(extractEmail(st));
    }
}

