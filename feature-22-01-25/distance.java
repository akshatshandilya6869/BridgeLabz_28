import java.util.*;
public class distance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the distance in feet: ");
        int distanceFeet = input.nextInt();
        double distanceYards = distanceFeet / 3.0;
        double distanceMiles = distanceYards / 1760;
        System.out.printf("The distance in yards is %.2f and in miles is %.2f\n\n",
                          distanceYards, distanceMiles);
    }
}
