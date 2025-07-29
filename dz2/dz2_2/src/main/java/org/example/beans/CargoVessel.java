package org.example.beans;

import org.example.interfaces.Cargo;
import org.example.interfaces.Fuel;
import org.example.interfaces.Vessel;
import org.springframework.beans.factory.annotation.Autowired;

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
    //@Autowired
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
