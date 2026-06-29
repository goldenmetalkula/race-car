package car;

/**
 * Represents a single tire on a {@link Car}.
 *
 * A tire's main job, for the purposes of this model, is to track its own
 * air pressure (in psi) and report whether it meets the minimum pressure
 * required for the car's engine to be allowed to start.
 */
public class Tire {

    /** The minimum pressure (in psi) a tire must have for the engine to start. */
    public static final double MINIMUM_SAFE_PSI = 32.0;

    private double pressurePsi;

    /**
     * Creates a new tire. Starts fully inflated at the minimum safe
     * pressure so a freshly-created Car is immediately drivable without
     * requiring extra setup calls.
     */
    public Tire() {
        this.pressurePsi = MINIMUM_SAFE_PSI;
    }

    /**
     * Creates a new tire with a specific starting pressure. Useful for
     * testing the "engine refuses to start" rule with an under-inflated
     * tire.
     *
     * @param pressurePsi the starting pressure, in psi
     */
    public Tire(double pressurePsi) {
        this.pressurePsi = pressurePsi;
    }

    /** @return the current pressure of this tire, in psi. */
    public double getPressurePsi() {
        return pressurePsi;
    }

    /**
     * Sets this tire's pressure directly (e.g. simulating pumping it up
     * or it slowly losing air).
     *
     * @param pressurePsi the new pressure, in psi
     */
    public void setPressurePsi(double pressurePsi) {
        this.pressurePsi = pressurePsi;
    }

    /**
     * @return true if this tire currently meets or exceeds the minimum
     *         safe pressure required for the engine to start.
     */
    public boolean isSafePressure() {
        return pressurePsi >= MINIMUM_SAFE_PSI;
    }

    @Override
    public String toString() {
        return String.format("Tire[%.1f psi, %s]", pressurePsi,
                isSafePressure() ? "OK" : "LOW");
    }
}
