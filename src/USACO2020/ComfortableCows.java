package USACO2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 2021 February Contest
// Silver
// Unfinished
public class ComfortableCows {
    public boolean[][] pasture;
    public boolean[][] simulated;

    public ComfortableCows() {
        pasture = new boolean[1000][1000];
        simulated = new boolean[1000][1000];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ComfortableCows field = new ComfortableCows();

        int n = Integer.parseInt(br.readLine());

        int requireAdded = 0;

        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");

            int x = Integer.parseInt(in[0]);
            int y = Integer.parseInt(in[1]);

            // Add the cow
            field.pasture[x][y] = true;
            field.simulated = field.pasture.clone();

            requireAdded += field.causesComfort(x, y);
            requireAdded += field.causesDiscomfort(x, y);

            System.out.println(requireAdded);
        }
    }

    private boolean checkCow(int x, int y) {
        try {
            return simulated[x][y];
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private boolean isComfortable(int x, int y) {
        return (checkCow(x + 1, y) && checkCow(x - 1, y) &&
                ((checkCow(x, y + 1) && !checkCow(x, y - 1)) || (checkCow(x, y - 1) && !checkCow(x, y + 1))))
                || (checkCow(x, y + 1) && checkCow(x, y - 1) &&
                ((checkCow(x + 1, y) && !checkCow(x - 1, y)) || (checkCow(x - 1, y) && !checkCow(x + 1, y))));
    }

    private int causesComfort(int x, int y) {
        int sum = 0;
        if (isComfortable(x, y)) sum++;

        boolean right = isComfortable(x + 1, y);
        boolean left = isComfortable(x - 1, y);
        boolean top = isComfortable(x, y + 1);
        boolean bottom = isComfortable(x, y - 1);

        if (!right && !left && !top && !bottom) return sum;

        if (right) sum++;
        if (left) sum++;
        if (top) sum++;
        if (bottom) sum++;

        return causesComfort(x + 1, y) + causesComfort(x - 1, y) + causesComfort(x, y + 1) + causesComfort(x, y - 1) + sum;
    }

    private int causesDiscomfort(int x, int y) {
        int discomforted = 0;

        if (checkCow(x - 1, y + 1) && checkCow(x, y + 1) && checkCow(x + 1, y + 1) && checkCow(x, y + 2))
            discomforted++;
        if (checkCow(x - 1, y + 1) && checkCow(x - 1, y) && checkCow(x - 1, y - 1) && checkCow(x - 2, y))
            discomforted++;
        if (checkCow(x + 1, y - 1) && checkCow(x + 1, y) && checkCow(x + 1, y + 1) && checkCow(x + 2, y))
            discomforted++;
        if (checkCow(x + 1, y - 1) && checkCow(x, y - 1) && checkCow(x - 1, y - 1) && checkCow(x, y - 2))
            discomforted++;

        return -discomforted;
    }
}
