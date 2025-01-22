public class volEarth {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double volumeKm3 = (4.0 / 3) * Math.PI * Math.pow(radiusKm, 3);
        double volumeMiles3 = volumeKm3 / Math.pow(1.609, 3);
        System.out.printf("The volume of Earth in cubic kilometers is %.2f and cubic miles is %.2f\n\n",
                          volumeKm3, volumeMiles3);
    }
}
