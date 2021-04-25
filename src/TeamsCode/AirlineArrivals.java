package TeamsCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Problem E, Easy 5
// 160, fails tests 1 and 3
public class AirlineArrivals {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] departureTime = br.readLine().split(":");
        int hours = Integer.parseInt(departureTime[0]);
        int minutes = Integer.parseInt(departureTime[1]);

        String[] values = br.readLine().split(" ");
        double speed = Double.parseDouble(values[0]);
        double distance = Double.parseDouble(values[1]);

        double flightTime = distance / speed;
        hours += (int) Math.floor(flightTime);

        int min = (int) Math.floor((flightTime % 1) * 60) + minutes;
        if (min > 60) {
            hours++;
            min %= 60;
        }

        String stringMinutes = String.valueOf(min);
        if (stringMinutes.length() == 1) stringMinutes = "0" + stringMinutes;

        String stringHours = String.valueOf(hours % 24);
        if (stringHours.length() == 1) stringHours = "0" + stringHours;

        System.out.println(stringHours + ":" + stringMinutes);
    }
}
