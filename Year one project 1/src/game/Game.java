package game;

import car.Car;
import car.Tire;
import racecars.RacingCar;

/**
 * Driver script for the Car model. Exercises a {@link RacingCar} through
 * its full lifecycle: a failed start due to low tire pressure, a
 * successful start, running at a few different speeds, an invalid speed
 * attempt, stopping, and finally restarting - demonstrating every rule
 * required of the {@link Car} class.
 */
public class Game {

    public static void main(String[] args) {

        System.out.println("=== Racing Car Demo ===");
        System.out.println();

        RacingCar car = new RacingCar("Apex Motorsports");
        System.out.println("Created: " + car);
        System.out.println();

        // ------------------------------------------------------------
        // 1. Demonstrate that the engine REFUSES to start if any tire
        //    is under-inflated.
        // ------------------------------------------------------------
        System.out.println("--- Step 1: Under-inflate a tire and try to start ---");
        car.getTires()[1].setPressurePsi(20.0); // tire #2 below the 32 psi minimum
        printTires(car);

        try {
            car.start();
        } catch (IllegalStateException ex) {
            System.out.println("Start failed as expected: " + ex.getMessage());
        }
        System.out.println();

        // ------------------------------------------------------------
        // 2. Re-inflate the tires (pit stop) and start successfully.
        // ------------------------------------------------------------
        System.out.println("--- Step 2: Pit stop to re-inflate tires, then start ---");
        car.pitStopReinflateTires();
        printTires(car);
        car.start();
        System.out.println("Is running? " + car.isRunning());
        System.out.println();

        // ------------------------------------------------------------
        // 3. Run the car at a few valid speeds within 1-60 mph.
        // ------------------------------------------------------------
        System.out.println("--- Step 3: Run at a few valid speeds (1-60 mph range) ---");
        car.run(1);
        car.run(35);
        car.run(60);
        System.out.println("Current speed: " + car.getCurrentSpeedMph() + " mph");
        System.out.println();

        // ------------------------------------------------------------
        // 4. Show this RacingCar can exceed the base Car's 60 mph cap,
        //    since it overrides getMaxSpeedMph().
        // ------------------------------------------------------------
        System.out.println("--- Step 4: RacingCar can run faster than a standard Car (up to "
                + car.getMaxSpeedMph() + " mph) ---");
        car.run(150);
        System.out.println();

        // ------------------------------------------------------------
        // 5. Attempt an invalid speed (out of range) and show it's rejected.
        // ------------------------------------------------------------
        System.out.println("--- Step 5: Attempt an invalid speed (0 mph) ---");
        try {
            car.run(0);
        } catch (IllegalArgumentException ex) {
            System.out.println("Run rejected as expected: " + ex.getMessage());
        }
        System.out.println();

        // ------------------------------------------------------------
        // 6. Stop the car.
        // ------------------------------------------------------------
        System.out.println("--- Step 6: Stop the car ---");
        car.stop();
        System.out.println("Is running? " + car.isRunning());
        System.out.println("Current speed: " + car.getCurrentSpeedMph() + " mph");
        System.out.println();

        // ------------------------------------------------------------
        // 7. Attempt to run while stopped, to show it's correctly blocked.
        // ------------------------------------------------------------
        System.out.println("--- Step 7: Attempt to run while stopped ---");
        try {
            car.run(20);
        } catch (IllegalStateException ex) {
            System.out.println("Run rejected as expected: " + ex.getMessage());
        }
        System.out.println();

        // ------------------------------------------------------------
        // 8. Restart the car after stopping, and run again, to prove the
        //    car can be cleanly restarted.
        // ------------------------------------------------------------
        System.out.println("--- Step 8: Restart the car and run again ---");
        car.start();
        car.run(45);
        System.out.println("Final state: " + car);

        System.out.println();
        System.out.println("=== Demo complete ===");
    }

    /** Prints the current pressure of all four tires on the given car. */
    private static void printTires(Car car) {
        Tire[] tires = car.getTires();
        for (int i = 0; i < tires.length; i++) {
            System.out.println("  Tire #" + (i + 1) + ": " + tires[i]);
        }
    }
}
