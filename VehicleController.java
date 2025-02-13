package com.numadic.vehicle_tracking.controller;

import com.numadic.vehicle_tracking.model.Vehicle;
import com.numadic.vehicle_tracking.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/register")
    public Vehicle registerVehicle(@RequestParam String vehicleNumber) {
        return vehicleService.registerVehicle(vehicleNumber);
    }

    @GetMapping("/track/{vehicleNumber}")
    public Optional<Vehicle> trackVehicle(@PathVariable String vehicleNumber) {
        return vehicleService.trackVehicle(vehicleNumber);
    }
}

