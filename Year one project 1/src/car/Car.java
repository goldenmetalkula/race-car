package car;

/**
 * Represents a generic car: something with exactly one {@link Engine} and
 * exactly four {@link Tire}s, that can be started, driven at a speed, and
 * stopped - and started again afterward.
 */
public class Car {

    /** Every Car has exactly one Engine. */
    protected final Engine engine;

    /** Every Car has exactly four Tires. */
    protected final Tire[] tires;

    private double currentSpeedMph;

    /**
     * Creates a new Car with a fresh Engine and four fresh, fully-inflated
     * Tires. The car starts at rest (not running, 0 mph).
     */
    public Car() {
        this.engine = new Engine();
        this.tires = new Tire[4];
        for (int i = 0; i < tires.length; i++) {
            tires[i] = new Tire();
        }
        this.currentSpeedMph = 0.0;
    }

    /**
     * Starts the car. Delegates to the Engine, which checks tire pressure.
     */
    public void start() {
        engine.start(tires);
        currentSpeedMph = 0.0;
        System.out.println(getClass().getSimpleName() + " started.");
    }

    /**
     * Drives the car at the given speed in miles per hour.
     *
     * @param speedMph the desired speed, in miles per hour
     */
    public void drive(double speedMph) {
        if (!engine.isRunning()) {
            throw new IllegalStateException(
                    "Cannot run the car: the engine is not started. Call start() first.");
        }
        if (speedMph < getMinSpeedMph() || speedMph > getMaxSpeedMph()) {
            throw new IllegalArgumentException(
                    "Speed must be between " + getMinSpeedMph() + " and " + getMaxSpeedMph()
                            + " mph (got " + speedMph + ").");
        }
        this.currentSpeedMph = speedMph;
        System.out.println(getClass().getSimpleName() + " running at " + speedMph + " mph.");
    }

    /**
     * Stops the car: brings it to a halt and stops the engine.
     */
    public void stop() {
        currentSpeedMph = 0.0;
        engine.stop();
        System.out.println(getClass().getSimpleName() + " stopped.");
    }

    /**
     * Restarts the car by stopping it and starting it again.
     */
    public void restart() {
        System.out.println("Restarting car...");
        stop();
        start();
    }

    /**
     * The slowest speed (in mph) this car is allowed to run at.
     */
    public double getMinSpeedMph() {
        return 1.0;
    }

    /**
     * The fastest speed (in mph) this car is allowed to run at.
     */
    public double getMaxSpeedMph() {
        return 60.0;
    }

    /** @return true if the engine is currently running. */
    public boolean isRunning() {
        return engine.isRunning();
    }

    /** @return the car's current speed, in mph (0 if stopped). */
    public double getCurrentSpeedMph() {
        return currentSpeedMph;
    }

    /** @return this car's Engine. */
    public Engine getEngine() {
        return engine;
    }

    /** @return this car's four Tires. */
    public Tire[] getTires() {
        return tires;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %.0f mph]", getClass().getSimpleName(),
                engine.isRunning() ? "RUNNING" : "STOPPED", currentSpeedMph);
    }
}