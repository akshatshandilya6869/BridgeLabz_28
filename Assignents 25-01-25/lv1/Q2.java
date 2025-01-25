import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = new int[5];

        for (int i = 0; i < num.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            num[i] = sc.nextInt();
        }

        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0) {
                if (num[i] % 2 == 0) {
                    System.out.println("The number " + num[i] + " is positive and even.");
                } else {
                    System.out.println("The number " + num[i] + " is positive and odd.");
                }
            } else if (num[i] < 0) {
                System.out.println("The number " + num[i] + " is negative.");
            } else {
                System.out.println("The number is zero.");
            }
        }

        if (numbers[0] > num[num.length - 1]) {
            System.out.printl("The first number is greater than the last number.");
        } else if (numbers[0] < num[num.length - 1]) {
            System.out.println("The first number is less than the last number.");
        } else {
            System.out.println("The first number is equal to the last number.");
        }
    }
}
