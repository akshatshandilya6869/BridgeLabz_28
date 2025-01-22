import java.util.*;
public class triangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the base of the triangle in cm: ");
        double base = input.nextDouble();
        System.out.print("Enter the height of the triangle in cm: ");
        double height = input.nextDouble();
        double areaCm2 = 0.5 * base * height;
        double areaInches2 = areaCm2 / 6.452;
        System.out.printf("The area of the triangle is %.2f square cm and %.2f square inches\n\n",
                          areaCm2, areaInches2);
    }
}
