import java.util.Scanner;

public classQ6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();

       
        double[] heights = new double[numPersons];
        double[] weights = new double[numPersons];
        double[] bmis = new double[numPersons];
        String[] weightStatus = new String[numPersons];

        
        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nEnter details for person " + (i + 1) + ":");
            System.out.print("Enter weight (in kg): ");
            weights[i] = scanner.nextDouble();

            System.out.print("Enter height (in cm): ");
            heights[i] = scanner.nextDouble();

            
            heights[i] /= 100;

            
            bmis[i] = weights[i] / (heights[i] * heights[i]);

        
            if (bmis[i] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmis[i] >= 18.5 && bmis[i] < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmis[i] >= 25 && bmis[i] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nDetails of all persons:");
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height(m)", "Weight(kg)", "BMI", "Weight Status");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s%n", heights[i], weights[i], bmis[i], weightStatus[i]);
        }

      
    }
}