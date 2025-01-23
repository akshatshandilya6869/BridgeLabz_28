import java.util.Scanner;

public class Q15{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number < 0) {
            System.out.println("Enter a positive integer");
            return;
        }

        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        System.out.println("Factorial: " + factorial);
    }
}
