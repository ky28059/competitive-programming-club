package TeamsCodeSpring2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Problem B, Easy 2
// Accepted
public class TrickyTaxes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int purchases = Integer.parseInt(br.readLine());

        for (int i = 0; i < purchases; i++) {
            String[] prices = br.readLine().split(" ");
            double beforeTax = Double.parseDouble(prices[0]);
            double afterTax = Double.parseDouble(prices[1]);

            double diff = afterTax - beforeTax;
            double percent = diff / beforeTax * 100;
            String rounded = String.valueOf((double) Math.round(percent * 100) / 100);
            if (rounded.split("\\.")[1].length() == 1) rounded += "0";

            System.out.println(rounded);
        }
    }
}
