package org.example.ex1.beans;

import org.example.ex1.interfaces.Cargo;
import org.example.ex1.interfaces.Fuel;
import org.example.ex1.interfaces.Vessel;

public class CargoVessel implements Vessel {
    private String name;
    private String type;
    private Cargo cargo;
    private Fuel fuel;
    private boolean engineRunning;

    public CargoVessel(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public void init() {
        this.engineRunning = true;
    }

    @Override
    public String status() {
        return "Vessel: " + name + ", type: "+ type +", status: " + (this.engineRunning ? "sails" : "stand by") + " \nCarries: " + cargo.aboutCargo() + "\nFuel status: " + fuel.value();
    }
}
