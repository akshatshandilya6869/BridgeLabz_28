import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input weight in kg
        System.out.print("Enter your weight (in kg): ");
        double weight = scanner.nextDouble();

        // Input height in cm
        System.out.print("Enter your height (in cm): ");
        double heightInCm = scanner.nextDouble();

        // Convert height from cm to meters
        double heightInMeters = heightInCm / 100;

        // Calculate BMI
        double bmi = weight / (heightInMeters * heightInMeters);

        // Determine weight status based on BMI
        String weightStatus;
        if (bmi < 18.5) {
            weightStatus = "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            weightStatus = "Normal weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            weightStatus = "Overweight";
        } else {
            weightStatus = "Obesity";
        }

        // Output the results
        System.out.println("\nBMI Results:");
        System.out.printf("Your BMI: %.2f%n", bmi);
        System.out.println("Weight Status: " + weightStatus);

        scanner.close();
    }
}