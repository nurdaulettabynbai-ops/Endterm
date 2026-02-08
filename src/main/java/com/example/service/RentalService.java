package com.example.rental.service;

import com.example.rental.dto.VehicleRequest;
import com.example.rental.dto.VehicleResponse;
import com.example.rental.model.VehicleBase;
import com.example.rental.patterns.VehicleFactory;
import com.example.rental.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalService {
    private final VehicleRepository repository;
    private final VehicleFactory factory;

    public RentalService(VehicleRepository repository, VehicleFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    public void addVehicle(VehicleRequest request) {
        // Используем Factory Pattern для создания
        VehicleBase vehicle = factory.createVehicle(request.getType(), request.getName(), request.getParameter());
        repository.save(vehicle);
    }

    public List<VehicleResponse> getAllVehicles() {
        return repository.findAll().stream()
                .map(v -> new VehicleResponse.Builder() // Используем Builder Pattern
                        .name(v.getName())
                        .type(v.getClass().getSimpleName())
                        .description(v.getDetails())
                        .build())
                .collect(Collectors.toList());
    }
}