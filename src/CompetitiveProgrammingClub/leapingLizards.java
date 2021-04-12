import java.util.Scanner;
import java.util.HashMap;

// Bad logic somewhere, dies test 4
public class leapingLizards {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String poles = in.nextLine();
        int n = Integer.parseInt(poles);
        //System.out.println("The end pole is pole #" + n);

        String heights = in.nextLine();
        String[] arrHeights = heights.split(" ");

        // Create hashmap of x and y coordinates
        HashMap<Integer, Integer> xy = new HashMap<Integer, Integer>(n);

        // Populate the map with the x and y coordinates
        for (int i = 0; i < arrHeights.length; i++) {
            // Inelegant but oh well
            xy.put(i + 1, Integer.parseInt(arrHeights[i])); // Poles are 1 indexed :(
        }

        // Lizard starts at pole 1
        int currentIndex = 1;
        int uniquePoles = 1; // Count the first pole

        // Stops when it reaches pole N
        while (currentIndex < n) {
            int currentHeight = xy.get(currentIndex);
            // Array of all slopes from this pole to every pole after
            // Inelegant
            double[] slopes = new double[n - currentIndex];

            // Loop through every pole after current and populate slopes
            // Inelegant
            for (int k = currentIndex + 1; k <= n; k++) {
                int height = xy.get(k);
                double deltaX = k - currentIndex;
                double deltaY = height - currentHeight;
                slopes[k - currentIndex - 1] = deltaY / deltaX;
                //System.out.println("Slope from " + currentIndex + " to " + k + ": " + deltaY / deltaX);
            }

            // Loop through slopes, find the max, and "jump" the lizard to it
            // Even more inelegance I suspect
            double max = -currentHeight; // Absolute minimum value for height
            int maxIndex = 0;
            for (int j = 0; j < slopes.length; j++) {
                double slope = slopes[j];
                // Lizard always jumps to the highest slope
                if (slope > max) {
                    //System.out.println("New max slope at pole #" + j + ": " + slope);
                    max = slope;
                    maxIndex = j + currentIndex + 1;
                }
            }

            //System.out.println("The Lizard has stood on " + uniquePoles + " poles, and is at pole #" + currentIndex);
            //System.out.println("The lizard will jump to pole #" + maxIndex);
            uniquePoles++;
            currentIndex = maxIndex;
        }

        System.out.println(uniquePoles);
    }
}