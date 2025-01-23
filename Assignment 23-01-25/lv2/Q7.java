import java.util.Scanner;

public class Q7{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the age and height of Amar:");
        int ageAmar = sc.nextInt();
        double heightAmar = sc.nextDouble();

        System.out.println("Enter the age and height of Akbar:");
        int ageAkbar = sc.nextInt();
        double heightAkbar = sc.nextDouble();

        System.out.println("Enter the age and height of Anthony:");
        int ageAnthony = sc.nextInt();
        double heightAnthony = sc.nextDouble();

        int youngestAge = Math.min(Math.min(ageAmar, ageAkbar), ageAnthony);
        double tallestHeight = Math.max(Math.max(heightAmar, heightAkbar), heightAnthony);

        if (youngestAge == ageAmar) {
            System.out.println("Amar is the youngest.");
        } else if (youngestAge == ageAkbar) {
            System.out.println("Akbar is the youngest.");
        } else {
            System.out.println("Anthony is the youngest.");
        }

        if (tallestHeight == heightAmar) {
            System.out.println("Amar is the tallest.");
        } else if (tallestHeight == heightAkbar) {
            System.out.println("Akbar is the tallest.");
        } else {
            System.out.println("Anthony is the tallest.");
        }
    }
}