import bustime.BusTimeBuilder;
import bustime.BusTimeStopMonitoring;
import bustime.BusTimeVehicleMonitoring;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author kevin
 * @date 8/8/14
 */
public class BusTimeTester {
    public static void main(String[] args) throws IOException {
        // Read the key from the key.txt file in our res folder
        String key = new Scanner(new File("res/key.txt")).nextLine();

        BusTimeBuilder builder = new BusTimeBuilder().setKey(key);

        BusTimeStopMonitoring stop = builder.createNewBusTimeStopMonitoring();
        BusTimeVehicleMonitoring vehicle = builder.createNewBusTimeVehicleMonitoring();



    }
}
