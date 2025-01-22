import java.util.Scanner;
public class square {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the perimeter of the square: ");
        int perimeter = input.nextInt();
        int side = perimeter / 4;
        System.out.printf("The length of the side is %d whose perimeter is %d\n\n", side, perimeter);

    }
}
