import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            while (true) {
                try {
                    System.out.print("Enter the age of " + friends[i] + ": ");
                    ages[i] = Integer.parseInt(sc.nextLine());
                    if (ages[i] <= 0) {
                        System.out.println("Invalid age. Please enter a positive number.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            while (true) {
                try {
                    System.out.print("Enter the height of " + friends[i] + " (in cm): ");
                    heights[i] = Double.parseDouble(sc.nextLine());
                    if (heights[i] <= 0) {
                        System.out.println("Invalid height. Please enter a positive number.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        }

        int youngestIndex = 0;
        int tallestIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        System.out.println(friends[youngestIndex] + " is the youngest.");
        System.out.println(friends[tallestIndex] + " is the tallest.");
    }
}
