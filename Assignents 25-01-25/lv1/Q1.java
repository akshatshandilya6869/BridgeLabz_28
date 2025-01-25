import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] age = new int[10];

        for (int i = 0; i < age.length; i++) {
            while (true) {
                System.out.print("Enter the age of student " + (i + 1) + ": ");
                age[i] = sc.nextInt();
                if (age[i] >= 0) {
                    break;
                } else {
                    System.out.println("Invalid age. Please enter a non-negative number.");
                }
            }
        }

        for (int i = 0; i < age.length; i++) {
            if (age[i] >= 18) {
                System.out.println("The student with the age " + age[i] + " can vote.");
            } else {
                System.out.println("The student with the age " + age[i] + " cannot vote.");
            }
        }
    }
}
