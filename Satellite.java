import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Satellite {
    private String orientation;
    private String solarPanels;
    private int dataCollected;
    private static final Logger logger = Logger.getLogger(Satellite.class.getName());

    // Constructor to initialize the satellite's attributes to their initial state
    public Satellite() {
        orientation = "North";
        solarPanels = "Inactive";
        dataCollected = 0;
    }

    // Method to rotate the satellite's orientation
    public void rotate(String direction) {
        String[] validDirections = {"North", "South", "East", "West"};
        boolean isValidDirection = false;

        for (String validDirection : validDirections) {
            if (validDirection.equals(direction)) {
                orientation = direction;
                isValidDirection = true;
                break;
            }
        }

        if (!isValidDirection) {
            logger.warning("Invalid direction. Use 'North', 'South', 'East', or 'West'.");
        }
    }

    // Method to activate the solar panels
    public void activatePanels() {
        solarPanels = "Active";
        logger.info("Solar panels activated.");
    }

    // Method to deactivate the solar panels
    public void deactivatePanels() {
        solarPanels = "Inactive";
        logger.info("Solar panels deactivated.");
    }

    // Method to collect data if the solar panels are active
    public void collectData() {
        try {
            if (solarPanels.equals("Active")) {
                dataCollected += 10;
            } else {
                logger.warning("Solar panels must be 'Active' to collect data.");
            }
        } catch (NumberFormatException e) {
            logger.severe("Error: Invalid input for collecting data.");
        }
    }

    // Method to get the current satellite status
    public String getSatelliteStatus() {
        return "Orientation: " + orientation + ", Solar Panels: " + solarPanels + ", Data Collected: " + dataCollected;
    }

    public static void main(String[] args) {
        // Configure logging
        configureLogging();

        Satellite satellite = new Satellite();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Satellite Control System");
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Rotate");
            System.out.println("2. Activate Panels");
            System.out.println("3. Deactivate Panels");
            System.out.println("4. Collect Data");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter direction (North/South/East/West): ");
                    String direction = scanner.next();
                    satellite.rotate(direction);
                    break;
                case 2:
                    satellite.activatePanels();
                    break;
                case 3:
                    satellite.deactivatePanels();
                    break;
                case 4:
                    satellite.collectData();
                    break;
                case 5:
                    System.out.println("Exiting Satellite Control System.");
                    scanner.close();
                    System.exit(0);
                default:
                    logger.warning("Invalid choice. Please choose a valid option.");
                    break;
            }

            System.out.println("Satellite Status:");
            System.out.println(satellite.getSatelliteStatus());
        }
    }

    // Configure logging properties
    private static void configureLogging() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.INFO); // Set the desired log level
    }
}
