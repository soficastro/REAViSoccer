import java.util.Scanner;

public class Resource {

    private boolean available;

    public Resource(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public static void resourcesReport (Systema system) {
        System.out.println("Vehicles:");

        if (system.vehicles.isEmpty()) System.out.println("Error");
        else {
            for (Bus object : system.vehicles) {
                System.out.println(object.toString());
            }
        }

        System.out.println("Stadium:");
        if(system.stadium.isAvailable()) {
            System.out.println( system.stadium.toString());
        } else System.out.println("Not available:");

        System.out.println("Training center:");
        if(system.trainingCenter.isAvailable()) {
            System.out.println( system.trainingCenter.toString());
        } else System.out.println("Not available:");

    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
