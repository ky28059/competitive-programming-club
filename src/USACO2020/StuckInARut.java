import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


// 2020 December Contest
// Bronze
public class StuckInARut {
    // Function to sort by column
    public static void sortbyColumn(int[][] arr, int col) {
        // Using built-in sort function Arrays.sort
        // Compare values according to columns
        Arrays.sort(arr, (entry1, entry2) -> {

            // To sort in descending order revert
            // the '>' Operator
            if (entry1[col] > entry2[col])
                return 1;
            else
                return -1;
        });  // End of function call sort().
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        ArrayList<int[]> north = new ArrayList<>();
        ArrayList<int[]> east = new ArrayList<>();
        String[][] all = new String[n][3];

        // Assign the east and north cow arrays
        for (int i = 0; i < n; i++) {
            String[] cow = in.readLine().split(" ");

            int[] coords = {Integer.parseInt(cow[1]), Integer.parseInt(cow[2])};

            if (cow[0].equals("E")) {
                east.add(coords);
            } else {
                north.add(coords);
            }
            all[i] = cow;
        }

        // Cast arraylists to matrices
        // This code sucks
        int[][] nth = new int[north.size()][2];
        nth = north.toArray(nth);
        int[][] est = new int[east.size()][2];
        est = east.toArray(est);

        // Sort matrices
        sortbyColumn(nth, 0);
        sortbyColumn(est, 1);

        // Sloppy repetition of code but whatever
        for (String[] cow : all) {
            int grass = checkCow(cow, est, nth);
            if (grass == 0) {
                System.out.println("Infinity");
            } else {
                System.out.println(grass);
            }
        }
    }

    public static int checkCow(String[] cow, int[][] est, int[][] nth) {
        int[] coords = {Integer.parseInt(cow[1]), Integer.parseInt(cow[2])};
        int thisX = coords[0];
        int thisY = coords[1];

        if (cow[0].equals("E")) {
            for (int[] c : nth) {
                int x = c[0];
                int y = c[1];

                // If the northward cow is below and to the right of this one
                // and if the distance between it and the intersection is shorter than ours
                // and if the other cow can actually make it to the intersection
                if (x > thisX && y <= thisY && (thisY - y < x - thisX)) {
                    // Reconstruct the other cow's string[] >:(
                    String[] otherCow = {"N", String.valueOf(x), String.valueOf(y)};
                    int otherDistance = checkCow(otherCow, est, nth);

                    if (otherDistance > thisY - y || otherDistance == 0) {
                        return x - thisX;
                    }
                }
            }
        } else {
            for (int[] c : est) {
                int x = c[0];
                int y = c[1];

                // If the eastward cow is on top and to the left of this one
                // and if the distance between it and the intersection is shorter than ours
                // and if the other cow can actually make it to the intersection
                if (y > thisY && x <= thisX && (thisX - x < y - thisY)) {
                    // Reconstruct the other cow's string[] >:(
                    String[] otherCow = {"E", String.valueOf(x), String.valueOf(y)};
                    int otherDistance = checkCow(otherCow, est, nth);

                    if (otherDistance > thisX - x || otherDistance == 0) {
                        return y - thisY;
                    }
                }
            }
        }

        return 0;
    }
}
