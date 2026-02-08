package com.example.rental.controller;

import com.example.rental.dto.VehicleRequest;
import com.example.rental.dto.VehicleResponse;
import com.example.rental.service.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class RentalController {
    private final RentalService service;

    public RentalController(RentalService service) {
        this.service = service;
    }

    @GetMapping
    public List<VehicleResponse> getAll() {
        return service.getAllVehicles();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody VehicleRequest request) {
        service.addVehicle(request);
    }
}