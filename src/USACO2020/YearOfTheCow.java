package USACO2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;


// 2021 February Contest
// Division: Silver
// Verdict: Passed
public class YearOfTheCow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);

        int[] ancestors = new int[n];

        // Get the n ancestor's years
        for (int i = 0; i < n; i++) {
            ancestors[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ancestors);

        int[] diffs = new int[n];

        // Get the differences between the new years needed to meet the ancestors
        for (int i = n - 1; i > 0; i--) {
            diffs[i] = nextNewYear(ancestors[i]) - lastNewYear(ancestors[i - 1]);
        }
        diffs[n - 1] = nextNewYear(ancestors[0]);

        Arrays.sort(diffs);

        // One jump is needed to go to the past
        int allowedJumps = k - 1;
        int[] jumps = new int[allowedJumps];

        // Use the allowed jumps on the biggest year differences
        for (int i = 0; i < allowedJumps; i++) {
            jumps[i] = diffs[n - 1 - i];
        }

        int past = lastNewYear(ancestors[ancestors.length - 1]);
        int skipped = IntStream.of(jumps).sum();
        System.out.println(past - skipped);
    }

    private static int lastNewYear(int yearsAgo) {
        return yearsAgo + (12 - (yearsAgo % 12));
    }

    private static int nextNewYear(int yearsAgo) {
        return yearsAgo - (yearsAgo % 12);
    }
}
