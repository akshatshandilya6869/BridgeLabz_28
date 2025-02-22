package Java_Regex;

import java.util.*;
import java.util.regex.*;

public class ValidateLicensePlate {
    public static boolean validPlate(String plate) {
        return plate.matches("^[A-Z]{2}\\d{4}$");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Plate Number:");
        String st = sc.nextLine();
        System.out.println(validPlate(st)?"Valid":"InValid");
    }
}
