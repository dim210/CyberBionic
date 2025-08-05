package com.dz4_jpa.persistence.models;

//import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "carsmarket")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "model_name")
    private String modelName;
    private Double price;

    @Override
    public String toString() {
        return String.join(", ", new String[]{
                "car: #" + id, brandName, modelName, price.toString()
        });
    }

    public Car() {
    }

    public Car(String brandName, String modelName, Double price) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.price = price;
    }
}
