package org.example.proj_module_reseaux.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.proj_module_reseaux.model.Driver;
import org.example.proj_module_reseaux.model.Location;
import org.example.proj_module_reseaux.repository.DriverRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }
    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver getDriverById(Long id){
        return driverRepository.getReferenceById(id);
    }

    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }

    public void deleteDriver(Long id){
        driverRepository.deleteById(id);
    }

    public Driver updateDriver(Long driverId, Driver updatedDriver) {
        // Check if the driver with the given ID exists
        Driver existingDriver = driverRepository.findById(driverId)
                .orElseThrow(() -> new EntityNotFoundException("Driver not found with ID: " + driverId));

        // Update the existing driver with the new information
        existingDriver.setName(updatedDriver.getName());
        existingDriver.setPhone(updatedDriver.getPhone());

        // Save the updated driver to the database
        return driverRepository.save(existingDriver);
    }

    public Driver updateLocation(long id, Location location) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with ID: " + id));
        driver.setLon(location.getLon());
        driver.setLat(location.getLat());
        return driverRepository.save(driver);
    }

    @Scheduled(fixedRate = 1000) // Update position every second
    public void updateDriverPosition() {
        // Simulate movement or update logic here
        // For demonstration purposes, we'll just increment/decrement the coordinates

        // Ensure the position stays within valid ranges, e.g., latitude [-90, 90], longitude [-180, 180]
        // You can add logic to reset the position or simulate movement within a specific area
    }
}
