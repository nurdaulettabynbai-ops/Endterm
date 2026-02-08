package com.example.rental.dto;

import lombok.Getter;

@Getter
public class VehicleResponse {
    private final String name;
    private final String type;
    private final String description;

    private VehicleResponse(Builder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.description = builder.description;
    }


    public static class Builder {
        private String name;
        private String type;
        private String description;

        public Builder name(String name) { this.name = name; return this; }
        public Builder type(String type) { this.type = type; return this; }
        public Builder description(String description) { this.description = description; return this; }

        public VehicleResponse build() {
            return new VehicleResponse(this);
        }
    }
}