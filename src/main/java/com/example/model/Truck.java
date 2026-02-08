package com.example.rental.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Truck extends VehicleBase {
    private double capacity;

    public Truck(int id, String name, double capacity) {
        super(id, name);
        this.capacity = capacity;
    }

    @Override
    public String getDetails() {
        return "Truck: " + getName() + " [Capacity: " + capacity + " tons]";
    }
}