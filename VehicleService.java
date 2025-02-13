package com.numadic.vehicle_tracking.service;

import com.numadic.vehicle_tracking.model.Vehicle;
import com.numadic.vehicle_tracking.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle registerVehicle(String vehicleNumber) {
        Vehicle vehicle = new Vehicle(vehicleNumber, "Unknown Location");
        return vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> trackVehicle(String vehicleNumber) {
        return Optional.ofNullable(vehicleRepository.findByVehicleNumber(vehicleNumber));
    }
}
