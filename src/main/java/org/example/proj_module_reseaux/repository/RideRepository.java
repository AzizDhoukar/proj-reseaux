package org.example.proj_module_reseaux.repository;

import org.example.proj_module_reseaux.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride> findByClientId(Long clientId);
    List<Ride> findByDriverId(Long driverId);
    List<Ride> findByPickupLocation(String pickupLocation);
    List<Ride> findByDropOffLocation(String dropOffLocation);
}

