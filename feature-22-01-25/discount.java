import java.util.Scanner;

public class discount {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.print("Enter the fee: ");
        double fee = input.nextInt();
        System.out.print("Enter the discount percentage: ");
        double discountPercent = input.nextDouble();
        double discount = (discountPercent / 100) * fee;
        double discountedFee = fee - discount;
        System.out.printf("The discount amount is INR %.2f and final discounted fee is INR %.2f\n\n",
                          discount, discountedFee);
    }
}
