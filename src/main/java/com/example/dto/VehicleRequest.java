package com.example.rental.dto;

import lombok.Data;

@Data
public class VehicleRequest {
    private String type;
    private String name;
    private double parameter;
}