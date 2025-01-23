import java.util.Scanner;

public class Q11 {
    public static void main(String[] args) {
        double total = 0.0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            double userInput = scanner.nextDouble();
            if (userInput <= 0) {
                break;
            }
            total += userInput;
        }

        System.out.println("Total: " + total);
    }
}
