import java.util.Scanner;

public class height {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your height in cm: ");
        int heightCm = input.nextInt();
        int feet = heightCm / 30;
        int inches = (int) ((heightCm / 2.54) % 12);
        System.out.printf("Your Height in cm is %d while in feet is %d and inches is %d\n\n",
                          heightCm, feet, inches);
    }
}
