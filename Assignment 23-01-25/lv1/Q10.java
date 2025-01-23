import java.util.Scanner;
class Q10 {
    public static void main(String[] args) {
        double total = 0.0;
        Scanner scanner = new Scanner(System.in);
        double userInput;

        while ((userInput = scanner.nextDouble()) != 0) {
            total += userInput;
        }

        System.out.println("Total: " + total);
    }
}

