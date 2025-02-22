package Java_Regex;

import java.util.*;
import java.util.regex.*;

public class ValidateHexColor {
    public static boolean validColor(String color) {
        return color.matches("^#[0-9a-fA-F]{6}$");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Color:");
        String st = sc.nextLine();
        System.out.println(validColor(st)?"Valid":"InValid");
    }
}
