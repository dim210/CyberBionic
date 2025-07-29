package org.example.beans;

import org.example.interfaces.Fuel;

public class DieselFuel implements Fuel {
    private static final String TYPE = "diesel";
    private int fuelAmount;

    public DieselFuel(int fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    @Override
    public String value() {
        return "amount of remaining " +this.TYPE+ " fuel is " +this.fuelAmount+ " liters";
    }
}
