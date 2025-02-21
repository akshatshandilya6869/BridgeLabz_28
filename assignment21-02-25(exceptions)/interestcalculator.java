import java.util.*;

public class InterestCalculator {
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            
            System.out.print("Enter rate: ");
            double rate = scanner.nextDouble();
            
            System.out.print("Enter years: ");
            int years = scanner.nextInt();
            
            double interest = calculateInterest(amount, rate, years);
            System.out.printf("Calculated Interest: %.2f\n", interest);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input: Please enter numeric values.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Operation completed.");
            scanner.close();
        }
    }
}