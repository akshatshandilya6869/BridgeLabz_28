package Java_Regex;

import java.util.*;
import java.util.regex.*;

public class ValidateUsername {
    public static boolean validUsername(String st) {
        return st.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username:");
        String st = sc.nextLine();
        System.out.println(validUsername(st)?"Valid":"InValid");
    }
}
