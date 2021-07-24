package LIT2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Forest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair<Integer, Integer>[] points = new Pair[n];

        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            int x = Integer.parseInt(in[0]);
            int y = Integer.parseInt(in[1]);

            points[i] = new Pair<>(x, y);
        }

        int max = 0;
        for (Pair<Integer, Integer> point : points) {
            int x1 = point.first;
            int y1 = point.second;

            for (Pair<Integer, Integer> point2 : points) {
                int x2 = point2.first;
                int y2 = point2.second;
                if (x1 == x2 && y1 == y2) continue;

                int sum = 2;
                int dx = Math.abs(x1 - x2);
                int dy = Math.abs(y1 - y2);

                for (Pair<Integer, Integer> point3 : points) {
                    int x3 = point3.first;
                    int y3 = point3.second;
                    if ((x1 == x3 && y1 == y3) || (x2 == x3 && y2 == y3)) continue;

                    boolean ok = checkSlope(dx, dy, x1, x3, y1, y3);
                    boolean ok2 = checkSlope(dx, dy, x2, x3, y2, y3);

                    //System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 + " " + x3 + " " + y3 + " " + ok + " " + ok2);
                    if (ok && ok2) sum++;
                }

                if (sum > max) max = sum;
            }
        }

        System.out.println(max);
    }

    public static boolean checkSlope(int dx, int dy, int x1, int x2, int y1, int y2) {
        int dx3 = Math.abs(x1 - x2);
        int dy3 = Math.abs(y1 - y2);

        if ((dx3 == 0 && dx == 0) || (dy3 == 0 && dy == 0)) return true;
        if ((dx3 == 0 || dx == 0) || (dy3 == 0 || dy == 0)) return false;

        boolean okx = dx3 == dx || (dx3 % dx == 0 || dx % dx3 == 0); // either same or divisible
        boolean oky = dy3 == dy || (dy3 % dy == 0 || dy % dy3 == 0);

        if (okx && oky) return Math.max(dx3, dx) / Math.min(dx3, dx) == Math.max(dy3, dy) / Math.min(dy3, dy);
        return false;
    }
}

class Pair<K, V> {
    K first;
    V second;

    public Pair(K first_value, V second_value) {
        first = first_value;
        second = second_value;
    }
}
