import java.util.Scanner;
public class l11 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter weight in pounds: ");
            double pounds = sc.nextDouble();
    
            double kilograms = pounds / 2.2;
    
            System.out.println("The weight of the person in pounds is " + pounds + " and in kilograms is " + kilograms);
        }
    }
    
