package com.example.rental.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Car extends VehicleBase {
    private int enginePower;

    public Car(int id, String name, int enginePower) {
        super(id, name);
        this.enginePower = enginePower;
    }

    @Override
    public String getDetails() {
        return "Car: " + getName() + " [Engine: " + enginePower + " HP]";
    }
}