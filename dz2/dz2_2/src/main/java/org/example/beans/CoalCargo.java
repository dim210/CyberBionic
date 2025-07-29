package org.example.beans;

import org.example.interfaces.Cargo;

public class CoalCargo implements Cargo {
    private static final String NAME = "coal";
    private int coalVolume;

    public CoalCargo(int coalVolume) {
        this.coalVolume = coalVolume;
    }

    @Override
    public String aboutCargo() {
        return "cargo of " + NAME + ", amount of " + coalVolume + " tons";
    }
}
