import java.util.Scanner;

public class Q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Not a natural number");
            return;
        }

        int sumByLoop = 0;
        for (int i = 1; i <= n; i++) {
            sumByLoop += i;
        }

        int sumByFormula = n * (n + 1) / 2;

        if (sumByLoop == sumByFormula) {
            System.out.println("Result is correct");
            System.out.println("Sum by loop: " + sumByLoop);
            System.out.println("Sum by formula: " + sumByFormula);
        } else {
            System.out.println("Results do not match");
        }
    }
}
