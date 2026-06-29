package racecars;

import car.Car;
import car.Tire;

/**
 * A specialized {@link Car} built for racing. Inherits all of the base
 * start/run/stop/restart rules and tire-pressure safety check from
 * {@link Car}, but is tuned to run faster than a standard car, and adds a
 * convenience method for simulating a "pit stop" (re-inflating all four
 * tires back to a safe pressure between runs).
 */
public class RacingCar extends Car {

    /** Racing cars are built to go faster than the 60 mph base-class limit. */
    private static final double RACING_MAX_SPEED_MPH = 220.0;

    private final String teamName;

    /**
     * Creates a new RacingCar for the given team, with a fresh engine and
     * four fresh, fully-inflated tires (inherited from {@link Car}).
     *
     * @param teamName the racing team this car belongs to
     */
    public RacingCar(String teamName) {
        super();
        this.teamName = teamName;
    }

    /**
     * Racing cars can run much faster than a standard car. The lower
     * bound (1 mph) is unchanged from the base Car class.
     */
    @Override
    public double getMaxSpeedMph() {
        return RACING_MAX_SPEED_MPH;
    }

    /**
     * Simulates a pit stop: re-inflates all four tires to the minimum
     * safe pressure. Useful after a long race where tire pressure might
     * have been deliberately lowered for a test, so the car can be
     * started again afterward.
     */
    public void pitStopReinflateTires() {
        for (Tire tire : tires) {
            tire.setPressurePsi(Tire.MINIMUM_SAFE_PSI);
        }
        System.out.println(teamName + "'s " + getClass().getSimpleName()
                + " completed a pit stop - all tires re-inflated.");
    }

    /** @return the name of the racing team this car belongs to. */
    public String getTeamName() {
        return teamName;
    }

    @Override
    public String toString() {
        return teamName + "'s " + super.toString();
    }
}
