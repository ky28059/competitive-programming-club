import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.DoubleStream;

public class DaisyChains {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] petals = in.readLine().split(" ");

        // Map the string numbers to doubles
        double[] p = new double[petals.length];
        for (int i = 0; i < petals.length; i++) {
            p[i] = Double.parseDouble(petals[i]);
        }

        int averages = 0;

        // Loop through all possible pairs
        for (int i = 0; i < petals.length; i++) {
            for (int k = i; k < petals.length; k++) {
                // Create a subarray of the flowers in the photo
                double[] photo = Arrays.copyOfRange(p, i, k + 1);
                double average = DoubleStream.of(photo).sum() / photo.length;

                // If any double in photo matches the average
                if (DoubleStream.of(photo).anyMatch(x -> x == average)) averages++;
            }
        }

        System.out.println(averages);
    }
}
