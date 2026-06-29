package car;

/**
 * Represents a Car's engine. Every {@link Car} has exactly one Engine.
 *
 * The Engine enforces one important safety rule on its own: it will not
 * start unless every one of the car's tires currently has at least
 * {@link Tire#MINIMUM_SAFE_PSI} psi of pressure. The Engine is given a
 * reference to the car's tires (rather than the whole Car) so it can check
 * this rule without needing to know anything else about the Car itself.
 */
public class Engine {

    private boolean running;

    /**
     * Creates a new Engine. Engines always begin in the stopped state;
     * {@link #start(Tire[])} must be called explicitly to turn it on.
     */
    public Engine() {
        this.running = false;
    }

    /**
     * Attempts to start the engine. The engine will only actually start if
     * every tire passed in currently meets the minimum safe pressure
     * ({@link Tire#MINIMUM_SAFE_PSI}). If any tire is under-inflated, the
     * engine refuses to start and an {@link IllegalStateException} is
     * thrown describing which tire(s) failed the check.
     *
     * @param tires the car's tires to validate before starting
     * @throws IllegalStateException if the engine is already running, or
     *         if one or more tires are below the minimum safe pressure
     */
    public void start(Tire[] tires) {
        if (running) {
            throw new IllegalStateException("Engine is already running.");
        }

        for (int i = 0; i < tires.length; i++) {
            if (!tires[i].isSafePressure()) {
                throw new IllegalStateException(
                        "Cannot start engine: Tire #" + (i + 1) + " is under-inflated ("
                                + tires[i].getPressurePsi() + " psi). All tires need at least "
                                + Tire.MINIMUM_SAFE_PSI + " psi.");
            }
        }

        running = true;
    }

    /**
     * Stops the engine. Safe to call even if the engine is already
     * stopped (it simply has no effect in that case).
     */
    public void stop() {
        running = false;
    }

    /** @return true if the engine is currently running. */
    public boolean isRunning() {
        return running;
    }

    @Override
    public String toString() {
        return "Engine[" + (running ? "RUNNING" : "STOPPED") + "]";
    }
}
