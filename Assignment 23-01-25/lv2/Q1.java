import java.util.Scanner;

public class Q1	 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        if (year < 1582) {
            System.out.println("Year must be >= 1582");
            return;
        }

        
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println("Year is a Leap Year");
                } else {
                    System.out.println("Year is not a Leap Year");
                }
            } else {
                System.out.println("Year is a Leap Year");
            }
        } else {
            System.out.println("Year is not a Leap Year");
        }

        
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            System.out.println("Year is a Leap Year");
        } else {
            System.out.println("Year is not a Leap Year");
        }
    }
}