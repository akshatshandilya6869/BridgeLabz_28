import java.util.Scanner;

public class Q14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number < 0) {
            System.out.println("Enter a positive integer");
            return;
        }

        int factorial = 1;
        while (number > 0) {
            factorial *= number;
            number--;
        }

        System.out.println("Factorial: " + factorial);
    }
}
