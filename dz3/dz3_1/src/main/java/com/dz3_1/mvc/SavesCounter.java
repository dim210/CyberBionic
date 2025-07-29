package com.dz3_1.mvc;

import lombok.Data;

@Data
public class SavesCounter implements RowCountable {
    private Integer sCounter = 0;

    @Override
    public void increment() {

        this.sCounter++;
        System.out.println("Increased counter value. Current value of counter: " + sCounter);
    }
    @Override
    public Integer getValue() {
        return this.sCounter;
    }
}
