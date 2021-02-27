import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// 2020 December Contest
// Bronze
public class ABCs {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = in.readLine().split(" ");

        // Map the string numbers to ints
        int[] n = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[i] = Integer.parseInt(nums[i]);
        }

        // Two of the numbers (a and b) will always be the lowest in the list
        // and the third can be found by subtracting a and b from the a + b + c number, which is always
        // the highest number in the list
        Arrays.sort(n);
        int a = n[0];
        int b = n[1];
        int c = n[n.length - 1] - a - b;

        System.out.println(a + " " + b + " " + c);
    }
}
