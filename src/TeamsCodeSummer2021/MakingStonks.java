package TeamsCodeSummer2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Problem 3
// Accepted
public class MakingStonks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        long x = Long.parseLong(in[1]);

        Pair<Long, Long>[] employees = new Pair[n];

        for (int i = 0; i < n; i++) {
            String[] in2 = br.readLine().split(" ");
            long t = Long.parseLong(in2[0]);
            long r = Long.parseLong(in2[1]);

            employees[i] = new Pair<>(t, r);
        }

        long left = 0;
        long right = Long.MAX_VALUE;
        while (left < right) {
            long mid = (left + right) / 2;
            long total = 0;

            for(int i = 0; i < n; i++) {
                long t = employees[i].first;
                long r = employees[i].second;

                if (t >= mid) continue;
                total += money(mid, r, t);
                if (total > x) break;
            }

            if (total >= x) { // mid too high
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    static long money(long time, long rate, long start) {
        time -= start;
        return (time - (time % rate)) / rate;
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
