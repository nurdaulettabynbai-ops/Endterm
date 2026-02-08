package com.example.rental.repository;

import com.example.rental.model.Car;
import com.example.rental.model.Truck;
import com.example.rental.model.VehicleBase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleRepository {
    private final JdbcTemplate jdbcTemplate;

    public VehicleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(VehicleBase vehicle) {
        String sql = "INSERT INTO vehicles (name, type, parameter) VALUES (?, ?, ?)";
        double param = (vehicle instanceof Car) ? ((Car) vehicle).getEnginePower() : ((Truck) vehicle).getCapacity();
        String type = (vehicle instanceof Car) ? "car" : "truck";

        jdbcTemplate.update(sql, vehicle.getName(), type, param);
    }

    public List<VehicleBase> findAll() {
        String sql = "SELECT * FROM vehicles";
        return jdbcTemplate.query(sql, vehicleRowMapper);
    }

    private final RowMapper<VehicleBase> vehicleRowMapper = (rs, rowNum) -> {
        String type = rs.getString("type");
        int id = rs.getInt("id");
        String name = rs.getString("name");
        double param = rs.getDouble("parameter");

        if ("car".equals(type)) {
            return new Car(id, name, (int) param);
        } else {
            return new Truck(id, name, param);
        }
    };
}