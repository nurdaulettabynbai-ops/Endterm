package com.example.rental.patterns;

public class DatabaseConnectionManager {
    private static DatabaseConnectionManager instance;
    private String connectionString;
    private DatabaseConnectionManager() {
        this.connectionString = "jdbc:postgresql://localhost:5432/rental_db";
    }
    public static synchronized DatabaseConnectionManager getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }

    public String getConnectionString() {
        return connectionString;
    }
}