package game;

import car.Car;

/**
 * Driver class to exercise the Race Car simulation.
 */
public class RaceCarGame {

    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.start();
        myCar.drive(45);
        myCar.drive(60);
        myCar.stop();
        myCar.restart();
        myCar.drive(30);
        myCar.stop();
    }
}

/**
 * Represents a single Tire with a PSI value.
 */
public class RaceCarGame {
    private double psi;

    public RaceCarGame(double psi) {
        this.psi = psi;
    }

    public double getPsi() { return psi; }
    public void setPsi(double psi) { this.psi = psi; }

    /**
     * Returns true if the tire has at least 32 psi.
     */
    public boolean isInflated() {
        return psi >= 32.0;
    }
}