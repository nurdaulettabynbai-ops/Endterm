# Rental System API (Endterm Project)

## Project Overview
This project is a RESTful API for a vehicle rental system, built with **Spring Boot**. It demonstrates the transition from a console-based application to a modern N-tier web architecture, integrating **Design Patterns**, **SOLID principles**, and **Component Principles** (REP, CCP, CRP).

## 🛠 Tech Stack
- **Java 17**
- **Spring Boot 3.2.3** (Web, JDBC)
- **PostgreSQL**
- **Lombok** & **Jackson**
- **Maven**

## 🚀 Architecture & Design Patterns
The project strictly follows the **Layered Architecture** (Controller -> Service -> Repository).

### [cite_start]1. Design Patterns Implementation [cite: 9]
* **Singleton Pattern** (`DatabaseConnectionManager`):
    * *Usage:* Ensures a single global instance for database configuration management.
    * *Why:* Prevents multiple resource-heavy configurations and ensures consistency.
* **Factory Pattern** (`VehicleFactory`):
    * *Usage:* Centralizes the creation logic for `Car` and `Truck` entities.
    * *Why:* Decouples the `RentalService` from concrete vehicle classes (OCP compliant).
* **Builder Pattern** (`VehicleResponse.Builder`):
    * *Usage:* Used to construct complex DTO objects for API responses.
    * *Why:* Provides a fluent interface for object creation and improves code readability.

### [cite_start]2. Component Principles [cite: 32]
* **REP (Reuse/Release Equivalence Principle):** Classes are grouped into cohesive packages (`model`, `dto`, `patterns`) for easy reuse.
* **CCP (Common Closure Principle):** Classes that change together (e.g., `Car` and `Truck` models) are packaged together.
* **CRP (Common Reuse Principle):** Interfaces like `CrudRepository` are separated to avoid forcing dependencies on unused methods.

## [cite_start]🔌 API Documentation [cite: 80]

### 1. Get All Vehicles
* **URL:** `/api/vehicles`
* **Method:** `GET`
* **Response:**
    ```json
    [
        {
            "name": "BMW M5",
            "type": "Car",
            "description": "Car: BMW M5 [Engine: 600 HP]"
        }
    ]
    ```

### 2. Add New Vehicle
* **URL:** `/api/vehicles`
* **Method:** `POST`
* **Body:**
    ```json
    {
        "type": "car", // or "truck"
        "name": "Tesla Model S",
        "parameter": 1020 // Engine Power for cars, Capacity for trucks
    }
    ```

## [cite_start]🏗 Database Schema [cite: 89]
```sql
CREATE TABLE vehicles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    parameter DOUBLE PRECISION
);
