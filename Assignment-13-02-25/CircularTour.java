
class CircularTour {
    // Function to find the starting petrol pump index
    public static int findStartingPump(int[] petrol, int[] distance) {
        int totalSurplus = 0;  // Total petrol surplus
        int currentSurplus = 0; // Surplus while traversing
        int startIndex = 0; // Starting pump index

        for (int i = 0; i < petrol.length; i++) {
            int netGain = petrol[i] - distance[i];
            totalSurplus += netGain;
            currentSurplus += netGain;

            // If at any point, surplus becomes negative, reset starting index
            if (currentSurplus < 0) {
                startIndex = i + 1; // Start from the next pump
                currentSurplus = 0; // Reset current surplus
            }
        }

        // If totalSurplus is negative, no solution exists
        return (totalSurplus >= 0) ? startIndex : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int startPump = findStartingPump(petrol, distance);
        if (startPump != -1) {
            System.out.println("Start at petrol pump: " + startPump);
        } else {
            System.out.println("No possible tour");
        }
    }
}

