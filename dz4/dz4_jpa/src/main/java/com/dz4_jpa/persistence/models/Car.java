package com.dz4_jpa.persistence.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "carsmarket")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String brand_name;
    private String model_name;
    private Double cost;

    @Override
    public String toString() {
        return String.join(", ", new String[]{
                "car: #" + id, brand_name, model_name, cost.toString()
        });
    }

    public Car() {
    }

    public Car(String brand_name, String model_name, Double cost) {
        this.brand_name = brand_name;
        this.model_name = model_name;
        this.cost = cost;
    }
}
