import java.util.*;
public class calc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double number1 = input.nextDouble();
        System.out.print("Enter second number: ");
        double number2 = input.nextDouble();
        System.out.printf("The addition is %.2f, subtraction is %.2f, multiplication is %.2f, division is %.2f\n\n",
                          number1 + number2, number1 - number2, number1 * number2, number1 / number2);

    }
}
