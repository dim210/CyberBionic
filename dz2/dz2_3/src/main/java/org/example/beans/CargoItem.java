package org.example.beans;

import org.example.interfaces.Cargo;

public class CargoItem implements Cargo {
    private String name;
    private int count;

    public CargoItem(String name, int count) {
        this.count = count;
    }

    @Override
    public String aboutCargo() {
        return "cargo of " + name + ", amount of " + count + " tons";
    }
}
