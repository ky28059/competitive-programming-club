package USACO2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 2021 January Contest
// Silver
// Dies on time because of excessive Queue<Set<Integer>> and other such structures
public class DanceMooves {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = in.readLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        Queue<Set<Integer>> swaps = new ArrayDeque<>();
        Queue<Integer> numbers = new ArrayDeque<>(); // Bad!

        // Populate swaps queue
        for (int i = 0; i < k; i++) {
            String[] swap = in.readLine().split(" ");
            Set<Integer> x = new HashSet<>();
            x.add(Integer.parseInt(swap[0]));
            x.add(Integer.parseInt(swap[1]));

            swaps.add(x);
            numbers.add(i);
        }
        // Clone for replacing
        Queue<Set<Integer>> original = new ArrayDeque<>(swaps);

        // Iterate through cows
        for (int i = 1; i < n + 1; i++) {
            swaps = new ArrayDeque<>(original);
            Hashtable<Integer, Integer> uniquePositions = new Hashtable<>();

            // Starting position of cow is i
            int[] currPos = {i, 0};
            int[] nextPos = matchFromNextSwap(swaps, numbers, currPos[0]);

            // Array sadness
            uniquePositions.put(currPos[0], currPos[1]);
            while (nextPos[0] != 0 && (uniquePositions.get(nextPos[0]) == null
                    || !uniquePositions.get(nextPos[0]).equals(nextPos[1]))) {
                currPos = nextPos;
                nextPos = matchFromNextSwap(swaps, numbers, currPos[0]);
                uniquePositions.put(currPos[0], currPos[1]);
            }

            System.out.println(uniquePositions.size());
        }
    }

    public static int[] matchFromNextSwap(Queue<Set<Integer>> swaps, Queue<Integer> numbers, int currPos) {
        int iterations = swaps.size();

        for (int i = 0; i < iterations; i++) {
            Set<Integer> swap = swaps.remove();
            int num = numbers.remove();

            // Bad code to get the match from the Set
            if (swap.contains(currPos)) {
                Iterator<Integer> x = swap.iterator();
                int one = x.next();

                swaps.add(swap);
                numbers.add(num);
                return new int[] {one != currPos ? one : x.next(), num};
            }

            swaps.add(swap);
            numbers.add(num);
        }

        // If no matches
        return new int[] {0};
    }
}
