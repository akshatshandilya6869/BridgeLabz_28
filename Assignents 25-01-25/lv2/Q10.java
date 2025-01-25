import java.util.Scanner;

public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int temp = Math.abs(num);
        int count = 0;
        int[] digits = new int[10];

        while (temp != 0) {
            digits[temp % 10]++;
            temp /= 10;
            count++;
        }

        System.out.println("Frequency of each digit:");
        for (int i = 0; i < 10; i++) {
            if (digits[i] > 0) {
                System.out.println("Digit " + i + ": " + digits[i]);
            }
        }
    }
}
