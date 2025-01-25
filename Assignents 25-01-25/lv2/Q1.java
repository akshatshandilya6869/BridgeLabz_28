import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];

       
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

       
        Scanner scanner = new Scanner(System.in);

        
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for employee " + (i + 1) + ":");

          
            while (true) {
                System.out.print("Salary: ");
                try {
                    salaries[i] = Double.parseDouble(scanner.nextLine());
                    if (salaries[i] <= 0) {
                        System.out.println("Invalid salary. Please enter a positive number.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            
            while (true) {
                System.out.print("Years of Service: ");
                try {
                    yearsOfService[i] = Double.parseDouble(scanner.nextLine());
                    if (yearsOfService[i] < 0) {
                        System.out.println("Invalid years of service. Please enter a non-negative number.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        }

        // Calculation loop
        for (int i = 0; i < 10; i++) {
            // Calculate bonus based on years of service
            if (yearsOfService[i] > 5) {
                bonuses[i] = salaries[i] * 0.05; // 5% bonus
            } else {
                bonuses[i] = salaries[i] * 0.02; // 2% bonus
            }

            // Calculate new salary
            newSalaries[i] = salaries[i] + bonuses[i];

            // Update totals
            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        // Output results
        System.out.println("\nResults:");
        System.out.printf("Total Bonus Payout: %.2f\n", totalBonus);
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);

        // Detailed breakdown for each employee (optional)
        System.out.println("\nEmployee Breakdown:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Employee %d - Old Salary: %.2f, Bonus: %.2f, New Salary: %.2f\n",
                    (i + 1), salaries[i], bonuses[i], newSalaries[i]);
        }

        // Close scanner
        scanner.close();
    }
}
