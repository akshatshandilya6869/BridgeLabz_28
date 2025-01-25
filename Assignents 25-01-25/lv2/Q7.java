import java.util.Scanner;

public class Q7{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();

       
        double[][] personData = new double[numPersons][3];
        String[] weightStatus = new String[numPersons];

      
        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nEnter details for person " + (i + 1) + ":");

            
            do {
                System.out.print("Enter weight (in kg, positive value): ");
                personData[i][0] = scanner.nextDouble();
                if (personData[i][0] <= 0) {
                    System.out.println("Invalid input. Weight must be a positive number.");
                }
            } while (personData[i][0] <= 0);

            // Input height (with validation)
            do {
                System.out.print("Enter height (in cm, positive value): ");
                personData[i][1] = scanner.nextDouble();
                if (personData[i][1] <= 0) {
                    System.out.println("Invalid input. Height must be a positive number.");
                }
            } while (personData[i][1] <= 0);

            
            personData[i][1] /= 100;

            
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);

            // Determine weight status based on BMI
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] >= 18.5 && personData[i][2] < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] >= 25 && personData[i][2] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display the height, weight, BMI, and weight status of each person
        System.out.println("\nDetails of all persons:");
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height(m)", "Weight(kg)", "BMI", "Weight Status");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s%n", 
                personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }

        
    }
}