import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number to generate its multiplication table: ");
        int nums = sc.nextInt();

        int[] multiplicationTable = new int[10];

        for (int i = 0; i < multiplicationTable.length; i++) {
            multiplicationTable[i] = nums * (i + 1);
        }

        System.out.println("Multiplication table of " + nums + ":");
        for (int i = 0; i < multiplicationTable.length; i++) {
            System.out.println(nums + " * " + (i + 1) + " = " + multiplicationTable[i]);
        }
    }
}