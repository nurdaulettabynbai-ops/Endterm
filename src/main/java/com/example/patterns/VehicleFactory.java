package com.example.rental.patterns;

import com.example.rental.model.Car;
import com.example.rental.model.Truck;
import com.example.rental.model.VehicleBase;
import org.springframework.stereotype.Component;

@Component
public class VehicleFactory {
    public VehicleBase createVehicle(String type, String name, double param) {
        if ("car".equalsIgnoreCase(type)) {
            return new Car(0, name, (int) param);
        } else if ("truck".equalsIgnoreCase(type)) {
            return new Truck(0, name, param);
        } else {
            throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}   