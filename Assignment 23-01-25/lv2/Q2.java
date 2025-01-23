import java.util.Scanner;
 public class LeapYear {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 int year = scanner.nextInt();
 if (year >= 1582 && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) {
 System.out.println("Year is a Leap Year"); 
 }
 else {
 System.out.println("Year is not a Leap Year"); 
 }
 }
 }
