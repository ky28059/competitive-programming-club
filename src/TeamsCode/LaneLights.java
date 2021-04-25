package TeamsCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

// Problem I, Medium 4
// Accepted
public class LaneLights {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int streetLength = Integer.parseInt(line1[1]);
        int radius = Integer.parseInt(line1[2]);

        int[] lamps = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(lamps);

        int darkSpots = 0;

        // For all middle lamps, look to the right
        for (int i = 0; i < lamps.length - 1; i++) {
            if (lamps[i] + radius < lamps[i + 1] - radius - 1) darkSpots++;
        }

        // Special edge cases
        if (lamps[0] - radius > 0) darkSpots++;
        if (lamps[lamps.length - 1] + radius < streetLength - 1) darkSpots++;

        System.out.println(darkSpots);
    }
}
